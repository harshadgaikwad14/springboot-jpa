package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorRequisition;

@Repository
public interface VendorRequisitionRepository extends CrudRepository<VendorRequisition, Long> {

	
}

