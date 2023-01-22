package com.jacaranda.tienda.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Category;
import com.jacaranda.tienda.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService serv;
	
	@GetMapping("/categoria/list")
	public String categoryList(Model model, @RequestParam("pageNumber")Optional<Integer> pageNumber,
			@RequestParam("sizeNumber") Optional<Integer> sizeNumber,
			@RequestParam("sortField") Optional<String> sortField,
			@RequestParam("stringFind") Optional<String> stringFind) {
		
		Page<Category> page = serv.getCategories(pageNumber.orElse(1), sizeNumber.orElse(10), sortField.orElse("code"), stringFind.orElse(null));
		
		model.addAttribute("currentPage", pageNumber.orElse(1));
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField.orElse("code"));
		model.addAttribute("keyword", stringFind.orElse(""));
		
		model.addAttribute("colors", page.getContent());
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
	public String deleteCategory(Model model, @RequestParam("id") String colorCode) {
		model.addAttribute("delCategory", serv.get(colorCode));
		return "deleteCategory";
	}
	@PostMapping("/categoria/delete")
	public String deleteSubmit(@ModelAttribute("delCategory") Category color) {
		serv.delete(color);
		return "redirect:/categoria/list";
	}
	
	
	@GetMapping("/categoria/update")
	public String updateCategory(Model model, @RequestParam("id") String colorCode) {
		model.addAttribute("upCategory", serv.get(colorCode));
		//model.addAttribute("flowerList", serv.get(colorCode).getFlowerList());
		return "updateCategory";
	}
	@PostMapping("/categoria/update")
	public String updateSubmit(@ModelAttribute("upCategory") Category color) {
		//@ModelAttribute("flowerList") ArrayList<Article> list
		//color.setFlowerList(list);
		serv.update(color);
		return "redirect:/categoria/list";
	}
}
