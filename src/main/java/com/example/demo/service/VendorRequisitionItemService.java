package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VendorRequisitionItem;
import com.example.demo.repository.VendorRequisitionItemRepository;

@Service
public class VendorRequisitionItemService {

	@Autowired
	private VendorRequisitionItemRepository vendorRequisitionItemRepository;

	public VendorRequisitionItem save(final VendorRequisitionItem vendorRequisitionItem) {
		return vendorRequisitionItemRepository.save(vendorRequisitionItem);
	}

	public List<VendorRequisitionItem> findAll() {

		return (List<VendorRequisitionItem>) vendorRequisitionItemRepository.findAll();
	}

	public void delete(final VendorRequisitionItem vendorRequisitionItem) {
		vendorRequisitionItemRepository.delete(vendorRequisitionItem);
	}

	public VendorRequisitionItem findById(final Long id) {
		return vendorRequisitionItemRepository.findById(id).get();
	}

	public List<VendorRequisitionItem> findAll(final Long id) {
		return (List<VendorRequisitionItem>) vendorRequisitionItemRepository.findAll();
	}

	public List<VendorRequisitionItem> findAllById(final List<Long> ids) {
		return (List<VendorRequisitionItem>) vendorRequisitionItemRepository.findAllById(ids);
	}

}
