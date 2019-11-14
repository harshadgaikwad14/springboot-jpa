package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryGroup;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategoryJoin;
import com.example.demo.entity.ProductProjection;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<CategoryGroup> groupBy() {
		return productRepository.groupBy();
	}

	public void save(final Product product) {
		productRepository.save(product);
	}

	public Product findById(long id) {
		return productRepository.findById(id).get();
	}

	public Product findByName(final String name) {
		return productRepository.findByName(name);
	}

	public List<ProductProjection> productProjection() {

		return productRepository.productProjection();
	}

	public Long sumQuantities() {
		return productRepository.sumQuantities();
	}

	public List<Product> findAllWithStoredProcedure() {
		return productRepository.findAllWithStoredProcedure();
	}

	public List<Product> findAllBetweenStoredProcedure(BigDecimal min, BigDecimal max) {
		return productRepository.findAllBetweenStoredProcedure(min, max);
	}

	public List<Product> findTopN(int n) {
		return productRepository.findTopN(n);
	}

	public List<Product> between(BigDecimal min, BigDecimal max) {
		return productRepository.between(min, max);
	}

	public List<Product> findByPrice(BigDecimal min, BigDecimal max) {
		return productRepository.findByPrice(min, max);
	}

	public List<Product> startsWith(String keyword) {
		return productRepository.startsWith(keyword);
	}

	public List<Product> endsWith(String keyword) {
		return productRepository.endsWith(keyword);
	}

	public List<Product> contains(String keyword) {
		return productRepository.contains(keyword);
	}

	public List<Product> orderByAscending() {
		return productRepository.orderByAscending();
	}

	public List<Product> orderByDescending() {
		return productRepository.orderByDescending();
	}

	public BigDecimal total() {
		return productRepository.total();
	}

	public BigDecimal min() {
		return productRepository.min();
	}

	public BigDecimal max() {
		return productRepository.max();
	}

	public Long count(boolean featured) {
		return productRepository.count(featured);
	}

	public List<ProductCategoryJoin> productCategoryJoin() {
		return productRepository.productCategoryJoin();
	}

}
