package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(long id) {
		return categoryRepository.findById(id).get();
	}
	
	public Category findByName(final String name) {
		return categoryRepository.findByName(name);
	}
	
	public List<Category> findByAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public void save(final Category category) {
		categoryRepository.save(category);
	}

}
