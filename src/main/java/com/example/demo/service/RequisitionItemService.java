package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RequisitionItem;
import com.example.demo.repository.RequisitionItemRepository;

@Service
public class RequisitionItemService {

	@Autowired
	private RequisitionItemRepository requisitionItemRepository;

	public RequisitionItem save(final RequisitionItem requisitionItem) {
		return requisitionItemRepository.save(requisitionItem);
	}
	
	
	


}
