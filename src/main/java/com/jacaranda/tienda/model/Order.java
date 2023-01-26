package com.jacaranda.tienda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	@ManyToOne
	@JoinColumn(name="user_code")
	private User user;
	@Column(name="iva")
	private final int IVA = 21;
	private LocalDate date;
	@OneToMany(mappedBy= "order", cascade= CascadeType.ALL, orphanRemoval = true)
	private List<Purchase> purchases = new ArrayList<>();

	public Order() {
		
	}
	
	public Order(User user) {
		this.user = user;
		this.date = LocalDate.now();
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

	public int getIva() {
		return this.IVA;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
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
		return "Order [code=" + code + ", user=" + user + ", iva=" + IVA + ", date=" + date + "]";
	}
	
}
