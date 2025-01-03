package com.sourav.order.product.entity;

import java.math.BigDecimal;


public class Product {

	private int id;
	private String name;
	private String description;
	private double availableQuantity;
	private BigDecimal price;
	private Category category;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String description, double availableQuantity, BigDecimal price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", availableQuantity=" + availableQuantity
				+ ", price=" + price + ", category=" + category + "]";
	}
	
	
}

