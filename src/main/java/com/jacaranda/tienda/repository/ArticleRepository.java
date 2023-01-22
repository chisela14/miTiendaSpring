package com.jacaranda.tienda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.model.Category;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	public Page<Article> findByNameLike(String keyword, Pageable pageable);
	
	public Page<Article> getByColor(Category color, Pageable pageable);

}
