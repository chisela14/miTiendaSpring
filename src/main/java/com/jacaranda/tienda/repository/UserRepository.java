package com.jacaranda.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jacaranda.tienda.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
	User findByVerificationCode(String code);

}
