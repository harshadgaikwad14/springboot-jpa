package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>, JpaSpecificationExecutor<Category> {

	Category findByName(final String name);
}