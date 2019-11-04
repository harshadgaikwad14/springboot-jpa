package com.example.demo.service;

import java.util.List;

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

	public void deleteRequisitionItem(final RequisitionItem requisitionItem) {
		requisitionItemRepository.delete(requisitionItem);
	}

	public RequisitionItem findById(final Long id) {
		return requisitionItemRepository.findById(id).get();
	}

	public List<RequisitionItem> findAll(final Long id) {
		return (List<RequisitionItem>) requisitionItemRepository.findAll();
	}

	public List<RequisitionItem> findAll(final List<Long> ids) {
		return (List<RequisitionItem>) requisitionItemRepository.findAllById(ids);
	}

}
