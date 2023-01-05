package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository rep;
	
	public List<Article> getArticles(){
		return rep.findAll();
	}
	
	public Article get(Long code) {
		return rep.findById(code).orElse(null);
	}
	
	public Article add(Article a) {
		return rep.save(a);
	}
	
	public void delete(Article a) {
		rep.delete(a);
	}
	
	public Article update(Article a) {
		return rep.save(a);
	}

}
