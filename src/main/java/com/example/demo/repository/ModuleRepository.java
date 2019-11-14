package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {

	public Module findByName(final String name);
}

