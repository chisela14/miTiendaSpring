package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Category;
import com.jacaranda.tienda.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository rep;
	
	public List<Category> getCategories(){
		return rep.findAll();
	}
	
	public Category get(String code) {
		return rep.findById(code).orElse(null);
	}
	
	public Category add(Category c) {
		return rep.save(c);
	}
	
	public void delete(Category c) {
		rep.delete(c);
	}
	
	public Category update(Category c) {
		return rep.save(c);
	}

}
