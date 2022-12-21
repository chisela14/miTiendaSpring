package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userServ;
	
	@GetMapping({"/", "/usuario/list"})
	public String userList(Model model) {
		model.addAttribute("userList", userServ.getUsers());
		return "userList";
	}
	
	@GetMapping("usuario/add")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "addUser";
	}
	
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

}
