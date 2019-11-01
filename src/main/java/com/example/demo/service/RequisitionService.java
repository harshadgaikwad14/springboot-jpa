package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Requisition;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.RequisitionRepository;

@Service
public class RequisitionService {

	@Autowired
	private RequisitionRepository requisitionRepository;

	public Requisition save(final Requisition requisition) {
		return requisitionRepository.save(requisition);
	}
	
	public Requisition findByName(final String name) {
		return requisitionRepository.findByName(name);
	}
	
	


}
