package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quotation;

@Repository
public interface QuotationRepository extends CrudRepository<Quotation, Long> {

	
	
	
}

