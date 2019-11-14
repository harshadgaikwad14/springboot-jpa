package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Operation;
import com.example.demo.repository.OperationRepository;

@Service
public class OperationService {

	@Autowired
	private OperationRepository operationRepository;

	public Operation save(final Operation operation) {
		return operationRepository.save(operation);
	}

	public Operation findByName(final String name) {
		return operationRepository.findByName(name);
	}

	public List<Operation> findAll() {

		return (List<Operation>) operationRepository.findAll();
	}

}
