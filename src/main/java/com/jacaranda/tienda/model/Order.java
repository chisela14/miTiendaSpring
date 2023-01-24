package com.jacaranda.tienda.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@ManyToOne
	@JoinColumn(
			name="user_code",
			insertable=false, updatable = false
			)
	private User user;
	@ManyToOne
	@JoinColumn(
			name="flower_code",
			insertable=false, updatable = false
			)
	private Article flower;
	private static int iva = 21;
	private LocalDate date;
	private int quantity; 

	public Order() {
		
	}
	
	public Order(User user, Article flower, LocalDate date, int quantity) {
		this.user = user;
		this.flower = flower;
		this.date = date;
		this.quantity = quantity;
	}


	public long getCode() {
		return code;
	}
	
	public void setCode(long code) {
		this.code = code;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getFlower() {
		return flower;
	}

	public void setFlower(Article flower) {
		this.flower = flower;
	}

	public int getIva() {
		return iva;
	}
	//el atributo iva es estático
	public void setIva(int iva) {
		Order.iva = iva;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return code == other.code;
	}

	@Override
	public String toString() {
		return "Order [code=" + code + ", user=" + user + ", flower=" + flower + ", iva=" + iva + ", date=" + date
				+ "]";
	}
	
}
