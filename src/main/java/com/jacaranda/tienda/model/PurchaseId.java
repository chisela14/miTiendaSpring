package com.jacaranda.tienda.model;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long order;
	private long flower;

	public PurchaseId() {
		
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public long getFlower() {
		return flower;
	}

	public void setFlower(long flower) {
		this.flower = flower;
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
		PurchaseId other = (PurchaseId) obj;
		return flower == other.flower && order == other.order;
	}
	
	

}
