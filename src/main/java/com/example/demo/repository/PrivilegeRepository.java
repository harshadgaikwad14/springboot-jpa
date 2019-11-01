package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	public Privilege findByName(final String privilegeName);
}
