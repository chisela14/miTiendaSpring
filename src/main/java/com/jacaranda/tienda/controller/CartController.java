package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Cart;
import com.jacaranda.tienda.service.ArticleService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	HttpSession ses;
	@Autowired
	ArticleService artServ;

	@GetMapping("/carrito")
	public String showCart(Model model) {
		//si la sesión no tiene carrito creo uno nuevo
		if(ses.getAttribute("cart")==null) {
			Cart newCart = new Cart();
			ses.setAttribute("cart", newCart);
		}
		Cart cart = (Cart) ses.getAttribute("cart");
		model.addAttribute("carro", cart.getArticles());
		return "cart";
	}
	
	@PostMapping("/carrito/add")
	public void addToCart(@RequestParam("article")Long articleCode,
			@RequestParam("quantity")Integer quantity) {
		//si la sesión no tiene carrito creo uno nuevo
		if(ses.getAttribute("cart")==null) {
			Cart newCart = new Cart();
			ses.setAttribute("cart", newCart);
		}
		//añado al carrito el artículo y la cantidad
		Cart cart = (Cart) ses.getAttribute("cart");
		cart.getArticles().put(artServ.get(articleCode), quantity);
		
	}
	
	@PostMapping("/carrito/clear")
	public void clearCart() {
		Cart cart = (Cart) ses.getAttribute("cart");
		cart.getArticles().clear();
	}
	

}
