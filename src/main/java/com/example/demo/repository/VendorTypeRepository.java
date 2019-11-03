package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Approver;
import com.example.demo.entity.VendorType;

@Repository
public interface VendorTypeRepository extends CrudRepository<VendorType, Long> {

	public VendorType findByName(final String name);
}

