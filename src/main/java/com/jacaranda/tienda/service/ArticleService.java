package com.jacaranda.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.Article;
import com.jacaranda.tienda.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository rep;
	
	public Page<Article> getArticles(int pageNum, int pageSize, String sortField, String stringFind){
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, Sort.by(sortField).ascending());
		//si el campo de búsqueda es nulo muestra todos los artículos
		if(stringFind == null) { 
			return rep.findAll(pageable);
		//si no lo es muestra los que tengan ese nombre
		}else { 
			return rep.findByNameLike('%' + stringFind + '%', pageable);//findByNameLike necesita el carácter comodín
		}
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
