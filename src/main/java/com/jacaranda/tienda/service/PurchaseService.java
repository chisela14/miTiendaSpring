package com.jacaranda.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Purchase;
import com.jacaranda.tienda.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository rep;

	public Purchase add(Purchase p) {
		return rep.save(p);
	}

}
