package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.tienda.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService serv;
	
	@GetMapping("/categoria/list")
	public String categoryList(Model model) {
		model.addAttribute("colors", serv.getCategories());
		return "categoryList";
	}

}
