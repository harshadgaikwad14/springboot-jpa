package com.example.demo.entity;

import java.math.BigDecimal;

public class ProductProjection implements java.io.Serializable {

	private long id;
	private String name;
	private BigDecimal price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductProjection(long id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public ProductProjection() {
	}

	@Override
	public String toString() {
		return "ProductProjection [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	
	
}