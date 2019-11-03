package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Grade;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

	public Grade findByName(final String name);
}

