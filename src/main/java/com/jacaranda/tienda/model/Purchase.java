package com.jacaranda.tienda.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="purchase")
@IdClass(PurchaseId.class)
public class Purchase {
	
	@Id
	@ManyToOne
	@JoinColumn(name="order_code")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name="flower_code")
	private Article flower;
	private int quantity;

	public Purchase() {
		
	}

	public Purchase(Order order, Article flower, int quantity) {
		this.order = order;
		this.flower = flower;
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Article getFlower() {
		return flower;
	}

	public void setFlower(Article flower) {
		this.flower = flower;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flower, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(flower, other.flower) && Objects.equals(order, other.order);
	}

	@Override
	public String toString() {
		return "Artículo: " + flower + " cant. - " + quantity;
	}
	
	

}
