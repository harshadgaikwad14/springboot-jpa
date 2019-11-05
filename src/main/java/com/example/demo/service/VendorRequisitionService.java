package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VendorRequisition;
import com.example.demo.repository.VendorRequisitionRepository;

@Service
public class VendorRequisitionService {

	@Autowired
	private VendorRequisitionRepository vendorRequisitionRepository;

	public VendorRequisition save(final VendorRequisition vendorRequisition) {
		return vendorRequisitionRepository.save(vendorRequisition);
	}

	public List<VendorRequisition> findAll() {

		return (List<VendorRequisition>) vendorRequisitionRepository.findAll();
	}

	public void delete(final VendorRequisition vendorRequisition) {
		vendorRequisitionRepository.delete(vendorRequisition);
	}

	public VendorRequisition findById(final Long id) {
		return vendorRequisitionRepository.findById(id).get();
	}

	public List<VendorRequisition> findAll(final Long id) {
		return (List<VendorRequisition>) vendorRequisitionRepository.findAll();
	}

	public List<VendorRequisition> findAllById(final List<Long> ids) {
		return (List<VendorRequisition>) vendorRequisitionRepository.findAllById(ids);
	}

	public List<VendorRequisition> findByVendorId(final Long vendorId) {
		return (List<VendorRequisition>) vendorRequisitionRepository.findByVendorId(vendorId);
	}

	public List<VendorRequisition> findByRequisitionId(final Long requisitionId) {
		return (List<VendorRequisition>) vendorRequisitionRepository.findByRequisitionId(requisitionId);
	}

	public VendorRequisition findByRequisitionIdAndVendorId(final Long requisitionId, final Long vendorId) {
		return vendorRequisitionRepository.findByRequisitionIdAndVendorId(requisitionId, vendorId);
	}
}
