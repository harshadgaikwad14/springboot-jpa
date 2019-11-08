package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	public PurchaseOrder save(final PurchaseOrder purchaseOrder) {
		return purchaseOrderRepository.save(purchaseOrder);
	}

	public void delete(final PurchaseOrder purchaseOrder) {
		purchaseOrderRepository.delete(purchaseOrder);
	}

	public PurchaseOrder findById(final Long id) {
		return purchaseOrderRepository.findById(id).get();
	}

	public List<PurchaseOrder> findAll(final Long id) {
		return (List<PurchaseOrder>) purchaseOrderRepository.findAll();
	}

	public List<PurchaseOrder> findAllById(final List<Long> ids) {
		return (List<PurchaseOrder>) purchaseOrderRepository.findAllById(ids);
	}

}
