package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Requisition;

@Repository
public interface RequisitionRepository extends CrudRepository<Requisition, Long> {

	public Requisition findByName(final String name);
}

