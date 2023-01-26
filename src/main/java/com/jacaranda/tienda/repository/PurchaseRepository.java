package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Purchase;
import com.jacaranda.tienda.model.PurchaseId;

public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseId> {

	

}
