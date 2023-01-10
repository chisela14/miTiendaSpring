package com.jacaranda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	
//	@Modifying(clearAutomatically = true) //anotación que permite hacer insert, delete y update
//	@Query("update Category c set c.name = ?1, c.description = ?2 where c.code = ?3")
//	void updateCategoryInfo(String name, String description, String code);

}
