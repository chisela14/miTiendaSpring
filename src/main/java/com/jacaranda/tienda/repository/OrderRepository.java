package com.jacaranda.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Order;
import com.jacaranda.tienda.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByUser(User user);
}
