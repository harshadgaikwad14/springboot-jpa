package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

	public Operation findByName(final String name);
}
