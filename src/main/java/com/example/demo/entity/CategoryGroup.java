package com.example.demo.entity;

import java.math.BigDecimal;

public class CategoryGroup {

	private long categoryId;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private Long sumQuantity;
	private Long countProduct;
	private Double avgPrice;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Long getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(Long sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public Long getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(Long countProduct) {
		this.countProduct = countProduct;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public CategoryGroup(long categoryId, BigDecimal minPrice, BigDecimal maxPrice, Long sumQuantity, Long countProduct, Double avgPrice) {
		this.categoryId = categoryId;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.sumQuantity = sumQuantity;
		this.countProduct = countProduct;
		this.avgPrice = avgPrice;
	}

	public CategoryGroup() {
	}

	@Override
	public String toString() {
		return "CategoryGroup [categoryId=" + categoryId + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", sumQuantity=" + sumQuantity + ", countProduct=" + countProduct + ", avgPrice=" + avgPrice + "]";
	}
	
	

}