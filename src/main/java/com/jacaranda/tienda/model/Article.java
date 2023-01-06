package com.jacaranda.tienda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="flower")
public class Article {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long code;
		private String name;
		private String description;
		private float price;
		@ManyToOne 
		@JoinColumn(name="color")
		private Category color;
		private int stock;
		@OneToMany(mappedBy= "flower", cascade= CascadeType.ALL, orphanRemoval = true)
		private List<Order> orders = new ArrayList<>();
		
		public Article() {
			
		}

		public Article(String name, String description, float price, Category color) {
			this.name = name;
			this.description = description;
			this.price = price;
			this.color = color;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public Category getColor() {
			return color;
		}

		public void setColor(Category color) {
			this.color = color;
		}

		public long getCode() {
			return code;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
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
			Article other = (Article) obj;
			return code == other.code;
		}

		@Override
		public String toString() {
			return code + " " + name + System.lineSeparator() + color.toString() + System.lineSeparator() +
					"Descripción: " + description + System.lineSeparator() + price + "€ --" + stock;
		}

}
