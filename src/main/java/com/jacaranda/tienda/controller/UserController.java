package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
