package com.jacaranda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.model.Cart;
import com.jacaranda.tienda.model.Order;
import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.service.ArticleService;
import com.jacaranda.tienda.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	ArticleService artServ;
	@Autowired 
	HttpSession session;
	@Autowired
	OrderService ordServ;
	
	//botón en navegación y redirección de otros controladores
	@GetMapping("/carrito")
	public String showCart(Model model){
		//si la sesión no tiene carrito creo uno nuevo
		if(session.getAttribute("cart")==null) {
			Cart newCart = new Cart();
			session.setAttribute("cart", newCart);
		}
		Cart cart = (Cart) session.getAttribute("cart");
		model.addAttribute("carro", cart.getArticles());
		model.addAttribute("total", cart.getTotal());
		return "cart";
	}
	//formulario para cambiar la cantidad de un artículo
	@PostMapping("/carrito/update")
	public String updateQuantity(Model model, @RequestParam("article")Long artCode, @RequestParam("quantity")int quantity) {
		Cart cart = (Cart) session.getAttribute("cart");
		Article a = artServ.get(artCode);
		cart.getArticles().put(a, quantity);
		//actualizar total
		//model.addAttribute("carro", cart.getArticles());
		//model.addAttribute("total", cart.getTotal());
		return "redirect:/carrito";
	}
	
	@PostMapping("/carrito/add")
	public String addToCart(Model model, @RequestParam("article")Long articleCode,
			@RequestParam("quantity")Integer quantity) {
		//si la sesión no tiene carrito creo uno nuevo
		if(session.getAttribute("cart")==null) {
			Cart newCart = new Cart();
			session.setAttribute("cart", newCart);
		}
		//añado al carrito el artículo y la cantidad
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getArticles().put(artServ.get(articleCode), quantity);
		model.addAttribute("carro", cart.getArticles());
		return "redirect:/articulo/list";
	}
	
	@PostMapping("/carrito/clear")
	public String clearCart() {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getArticles().clear();
		return "redirect:/carrito";
	}
	
	@PostMapping("/carrito/purchase")
	public String purchase(@AuthenticationPrincipal User user) {
		Cart c = (Cart) session.getAttribute("cart");
		
		for(Article article: c.getArticles().keySet()) {
			int quantity = c.getArticles().get(article);
			System.out.println(quantity);
			//ajustar el stock
			Article bdArt = artServ.get(article.getCode());
			bdArt.setStock(bdArt.getStock()- quantity);
			artServ.update(bdArt);
			//guardar el pedido en la base de datos
			Order order = new Order(user, bdArt, quantity);
			ordServ.add(order);
		}
		
		c.getArticles().clear();
		
		return "purchaseSuccess";
	}
	

}
