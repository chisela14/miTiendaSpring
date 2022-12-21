package com.jacaranda.tienda.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")//he tenido que ponerlo en minúsculas aquí y en la bd porque algo
//lo pasa a minúsculas y daba error de no encontrado
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	private String email; 
	private boolean admin;
//	@OneToMany(mappedBy= "user", cascade= CascadeType.ALL, orphanRemoval = true)
//	private List<Order> orders = new ArrayList<>();

	public User() {
		
	}
	
	/**
	 * Constructor de la clase User con todos los parámetros menos si será admin o no, porque por defecto
	 * no lo será
	 * @param username nombre de usuario del usuario
	 * @param password contraseña ya encriptada
	 * @param name nombre del usuario
	 * @param email correo electrónico
	 * @throws UserException lanza esta exception propagada de los setters si alguno de los parámetros no es correcto
	 */
	
	public User(String username, String password, String name, String email) throws UserException {
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setEmail(email);
		this.admin = false;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws UserException {
		if(username == null || username.isEmpty()) {
			throw new UserException("El nombre de usuario no es válido");
		}else {
			this.username = username;
		}
	}

	public String getPassword() { 
		return password;
	}
	
	/**
	 * Función que establece la contraseña del usuario comprobando que no esté vacía o sea nula
	 * @param password contraseña ya codificada
	 * @throws UserException lanza la exception si la contraseña está vacía o es nula
	 */
	public void setPassword(String password) throws UserException { 
		if(password == null || password.isEmpty()) {
			throw new UserException("La contraseña no es válida");
		}else {
			this.password = password;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws UserException {
		if(name == null || name.isEmpty()) {
			throw new UserException("El nombre no es válido");
		}else {
			this.name = name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", admin=" + admin + "]";
	}

}