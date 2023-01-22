package com.jacaranda.tienda.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.model.UserException;
import com.jacaranda.tienda.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository rep;
	
	@Autowired
	private JavaMailSender mailSender;

	public Page<User> getUsers(int pageNum, int pageSize, String sortField, String stringFind){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, Sort.by(sortField).ascending());
		//si el campo de búsqueda es nulo muestra todos los artículos
		if(stringFind == null) { 
			return rep.findAll(pageable);
		//si no lo es muestra los que tengan ese nombre
		}else { 
			return rep.findByNameLike('%' + stringFind + '%', pageable);//findByNameLike necesita el carácter comodín
		}
	}
	
	public User get(String username) {
		return rep.findById(username).orElse(null);
	}
	
	public void add(User s, String siteURL) throws UnsupportedEncodingException, MessagingException, UserException {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String encodedPassword = passwordEncoder.encode(s.getPassword());

		s.setPassword(encodedPassword);
		// Genera una cadena aleatoria que guarderemos en el código de verificación y que
		// le enviaremos al usuario para saber que es él.
		String randomCode = RandomString.make(64);
		s.setVerificationCode(randomCode);
		s.setEnabled(false);
		s.setAdmin(false);
		rep.save(s);
		sendVerificationEmail(s, siteURL);
	}
	
	public void delete(User u) {
		rep.delete(u);
	}
	
	public User update(User u) {
		return rep.save(u);
	}
	
	public boolean checkExist(User s) {
		boolean resultado = false;
		// Comprueba que no existe el nombre del usuario
		User checkUser = rep.findById(s.getUsername()).orElse(null);
		// Comprueba que no existe el email en la base de datos
		List<User> checkPassword = rep.findByEmail(s.getEmail());
		if (checkUser == null && checkPassword.size() == 0) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = rep.findById(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}
	
	private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
		String fromAddress = "cmcg.dev@gmail.com";
		String senderName = "Jacaranda";
		String subject = "Please verify your registration";
		String content = "Dear [[user]],<br>" + "Please click the link below to verify your registration:<br>"
		+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "Your company name.";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		content = content.replace("[[user]]", user.getUsername());
		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

		content = content.replace("[[URL]]", verifyURL);
		helper.setText(content, true);
		mailSender.send(message);
	}
	
	public boolean verify(String verificationCode) {
		boolean result = false;
		User user = rep.findByVerificationCode(verificationCode);
		if (user != null && !user.isEnabled()) {
			user.setVerificationCode(null);
			user.setEnabled(true);
			rep.save(user);
			result = true;
		} 
		
		return result;	
	
	}

}
