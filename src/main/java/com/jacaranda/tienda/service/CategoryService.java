package com.jacaranda.tienda.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Page<Category> getCategories(int pageNum, int pageSize, String sortField, String stringFind){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, Sort.by(sortField).ascending());
		//si el campo de búsqueda es nulo muestra todos los artículos
		if(stringFind == null) { 
			return rep.findAll(pageable);
		//si no lo es muestra los que tengan ese nombre
		}else { 
			return rep.findByNameLike('%' + stringFind + '%', pageable);//findByNameLike necesita el carácter comodín
		}
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
	
	public void update(Category c) {
		Category color = get(c.getCode());
		color.setName(c.getName());
		color.setDescription(c.getDescription());
		rep.save(color);
	}

}
