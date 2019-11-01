package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	


}
