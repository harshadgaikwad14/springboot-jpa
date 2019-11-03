package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Unit;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {

	public Unit findByName(final String name);
}

