package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Order;
import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository rep;
	@Autowired
	ArticleService artServ;
	@Autowired
	UserService userServ;
	
	public Order add(Order o) {
		return rep.save(o);
	}
	
	public List<Order> getOrders(User user){
		return rep.findByUser(user);
	}
	
}
