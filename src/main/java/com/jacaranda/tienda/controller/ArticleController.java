package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.tienda.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService serv;
	
	@GetMapping({"/", "/articulo/list"})
	public String articleList(Model model) {
		model.addAttribute("articleList", serv.getArticles());
		return "articleList";
	}

}
