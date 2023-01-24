package com.jacaranda.tienda.model;

import java.util.HashMap;

public class Cart {
	
	private HashMap<Article, Integer> articles; //artículo y cantidad
	//el usuario se obtiene de la autenticación
	//la fecha será la del sistema cuando se realice la compra
	//el iva será 21 automáticamente al crear el objeto con la variable estática

	public Cart() {
		this.articles = new HashMap <>();
	}

	public HashMap<Article, Integer> getArticles() {
		return articles;
	}

	public void setArticles(HashMap<Article, Integer> articles) {
		this.articles = articles;
	}
	
	
}
