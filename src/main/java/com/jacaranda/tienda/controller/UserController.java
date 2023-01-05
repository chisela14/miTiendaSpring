package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userServ;
	
	@GetMapping("/usuario/list")
	public String userList(Model model) {
		model.addAttribute("users", userServ.getUsers());
		return "userList";
	}
	
	@GetMapping("usuario/add")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "addUser";
	}
	
	//validaciones que se puedan, la comprobación de que las contraseñas coinciden
	//le corresponde al cliente
	@PostMapping("usuario/add")
	public String addSubmit( @Validated @ModelAttribute("newUser") User u,
			BindingResult bindingResult) {
		//TO DO la contraseña no coincide
		//puedo hacerlo recogiendo el param por post?
		if (bindingResult.hasErrors()) { 
			return "addUser";
		}else {
			userServ.add(u);
			return "redirect:/usuario/list";
		}
	}
	
	@GetMapping("usuario/delete")
	public String deleteUser(Model model, @RequestParam("username") String username) {
		User user = userServ.get(username);
		model.addAttribute("userDel", user);
		return "deleteUser";
	}
	
	@PostMapping("usuario/delete")
	public String deleteSubmit(@ModelAttribute("userDel") User user) {
		userServ.delete(user);
		return "redirect:/usuario/list";
	}
	
	@GetMapping("usuario/update")
	public String updateUser(Model model, @RequestParam("username") String username) {
		User user = userServ.get(username);
		model.addAttribute("userUp", user);
		return "updateUser";
	}
	
	@PostMapping("usuario/update")
	public String updateSubmit(@ModelAttribute("userUp") User user) {
		userServ.update(user);
		return "redirect:/usuario/list";
	}
	
	@GetMapping("usuario/admin")
	public String changeAdmin(Model model, @RequestParam("username") String username) {
		User user = userServ.get(username);
		model.addAttribute("userAdm", user);
		return "changeAdmin";
	}
	
	//cuidado con que la contraseña se guarde vacía porque no entrará por aquí
	@PostMapping("usuario/admin")
	public String adminSubmit(@ModelAttribute("userAdm") User user) {
		userServ.update(user);
		return "redirect:/usuario/list";
	}
	


}
