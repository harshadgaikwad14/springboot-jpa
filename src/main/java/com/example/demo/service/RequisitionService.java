package com.example.demo.service;

import java.util.List;

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

	public List<Requisition> findAll() {

		return (List<Requisition>) requisitionRepository.findAll();
	}

	public void delete(final Requisition requisition) {
		requisitionRepository.delete(requisition);
	}

	public Requisition findById(final Long id) {
		return requisitionRepository.findById(id).get();
	}

	public List<Requisition> findAll(final Long id) {
		return (List<Requisition>) requisitionRepository.findAll();
	}

	public List<Requisition> findAllById(final List<Long> ids) {
		return (List<Requisition>) requisitionRepository.findAllById(ids);
	}

}
