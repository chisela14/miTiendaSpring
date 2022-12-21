package com.jacaranda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRep;

	public List<User> getUsers() {
		return userRep.findAll();
	}
	
	public User add(User u) {
		return userRep.save(u);
	}

}
