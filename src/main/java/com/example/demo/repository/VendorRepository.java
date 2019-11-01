package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

	public Vendor findByName(final String name);
}

