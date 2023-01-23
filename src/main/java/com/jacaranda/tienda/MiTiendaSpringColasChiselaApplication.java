package com.jacaranda.tienda;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class MiTiendaSpringColasChiselaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiTiendaSpringColasChiselaApplication.class, args);
	}
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "ddrd0qdr2");
		config.put("api_key", "755218483878951");
	
		config.put("api_secret", "XnPYc4powid4bn-epQOcLWqkHuw");
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}

}
