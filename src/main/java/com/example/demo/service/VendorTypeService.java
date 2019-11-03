package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VendorType;
import com.example.demo.repository.VendorTypeRepository;

@Service
public class VendorTypeService {

	@Autowired
	private VendorTypeRepository vendorTypeRepository;

	public VendorType save(final VendorType vendorType) {
		return vendorTypeRepository.save(vendorType);
	}

	public VendorType findByName(final String name) {
		return vendorTypeRepository.findByName(name);
	}

	public List<VendorType> findAll() {

		return (List<VendorType>) vendorTypeRepository.findAll();
	}

}
