package com.jacaranda.tienda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jacaranda.tienda.service.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private UserService myUserDetailService;
	
	// Indicamos que la configuración se hará a travéx del servicio.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService);
	}
	
	// Método que usaremos más abajo
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}
	
	// Método que nos suministrará la codificación
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Método que autentifica
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	// Aquí es donde podemos especificar qué es lo que hace y lo que no
	// según el rol del usuario
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
		{requests
			.requestMatchers("/css").permitAll()
			.requestMatchers("/login").permitAll()
			.requestMatchers("/signUp").permitAll()
			.requestMatchers("/usuario/verify/**").permitAll()
			.requestMatchers("/usuario/add").permitAll()
			//el orden es importante, si ya tiene una regla para admin no reaplicará otra para user
			.requestMatchers("/").hasAnyAuthority("USER", "ADMIN")
			.requestMatchers("/articulo/list").hasAnyAuthority("USER", "ADMIN")
			.requestMatchers("/articulo/**").hasAuthority("ADMIN")
			
			.requestMatchers("/usuario/update").hasAnyAuthority("USER", "ADMIN")//controlar en la plantilla
			.requestMatchers("/usuario/update/**").hasAnyAuthority("USER", "ADMIN")//controlar en la plantilla
			.requestMatchers("/usuario/orders").hasAnyAuthority("USER", "ADMIN")//controlar en la plantilla
			.requestMatchers("/usuario/**").hasAuthority("ADMIN")
			
			.requestMatchers("/categoria/list").hasAnyAuthority("USER", "ADMIN")
			.requestMatchers("/categoria/**").hasAuthority("ADMIN")
			.requestMatchers("/carrito/**").hasAuthority("USER")
			.anyRequest().authenticated();
		})
		.formLogin((form) -> form
			//.loginPage("/login")
			.permitAll())
		.logout((logout) -> logout.logoutSuccessUrl("/login")
				.permitAll());
	
		return http.build();
	}

}
