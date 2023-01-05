package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
