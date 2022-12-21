package com.jacaranda.tienda.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Order() {
		// TODO Auto-generated constructor stub
	}

}
