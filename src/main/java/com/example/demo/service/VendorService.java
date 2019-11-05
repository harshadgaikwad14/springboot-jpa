package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	public Vendor save(final Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	public Vendor findByName(final String name) {
		return vendorRepository.findByName(name);
	}
	
	public List<Vendor> findAll() {

		return (List<Vendor>) vendorRepository.findAll();
	}

	public void delete(final Vendor vendor) {
		vendorRepository.delete(vendor);
	}

	public Vendor findById(final Long id) {
		return vendorRepository.findById(id).get();
	}

	public List<Vendor> findAll(final Long id) {
		return (List<Vendor>) vendorRepository.findAll();
	}

	public List<Vendor> findAllById(final List<Long> ids) {
		return (List<Vendor>) vendorRepository.findAllById(ids);
	}
	
	


}
