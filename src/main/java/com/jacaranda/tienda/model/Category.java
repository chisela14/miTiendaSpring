package com.jacaranda.tienda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="color")
public class Category {

	@Id
	private String code;
	private String name;
	private String description;
	@OneToMany(mappedBy ="color", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Article> flowerList;
	
	public Category() {
		
	}
	public Category(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
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

	public List<Article> getFlowerList() {
		return flowerList;
	}

	public void setFlowerList(ArrayList<Article> flowerList) {
		this.flowerList = flowerList;
	}

	public String getCode() {
		return code;
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
		Category other = (Category) obj;
		return Objects.equals(code, other.code);
	}
	@Override
	public String toString() {
		return code + System.lineSeparator() + name; //hay alguna manera de añadir aquí un salto de línea para html?
	}


}
