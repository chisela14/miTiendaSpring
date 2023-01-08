package com.jacaranda.tienda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.model.Category;
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
	
	
	@GetMapping("/categoria/add")
	public String addCategory(Model model) {
		Category c = new Category();
		model.addAttribute("newCategory", c);
		return "addCategory";
	}
	@PostMapping("/categoria/add")
	public String addSubmit(@ModelAttribute("newCategory") Category color) {
		serv.add(color);
		return "redirect:/categoria/list";
	}
	
	
	@GetMapping("/categoria/delete")
	public String deleteCategory(Model model, @RequestParam("code") String colorCode) {
		model.addAttribute("delCategory", serv.get(colorCode));
		return "deleteCategory";
	}
	@PostMapping("/categoria/delete")
	public String deleteSubmit(@ModelAttribute("delCategory") Category color) {
		serv.delete(color);
		return "redirect:/categoria/list";
	}
	
	
	@GetMapping("/categoria/update")
	public String updateCategory(Model model, @RequestParam("code") String colorCode) {
		model.addAttribute("upCategory", serv.get(colorCode));
		model.addAttribute("flowerlist", serv.get(colorCode).getFlowerList());//esto está bien así o debería pasarlo por el formulario?
		return "updateCategory";
	}
	@PostMapping("/categoria/update")
	public String updateSubmit(@ModelAttribute("upCategory") Category color, @ModelAttribute("flowerList") ArrayList<Article> list) {
		color.setFlowerList(list);
		serv.update(color);
		return "redirect:/categoria/list";
	}
}
