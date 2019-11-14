package com.example.demo.entity;

import java.math.BigDecimal;

public class ProductCategoryJoin implements java.io.Serializable {

	private long id;
	private String name;
	private BigDecimal price;
	private long categoryId;
	private String categoryName;

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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ProductCategoryJoin(long id, String name, BigDecimal price, long categoryId, String categoryName) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public ProductCategoryJoin() {
	}

	@Override
	public String toString() {
		return "ProductCategoryJoin [id=" + id + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + "]";
	}

}