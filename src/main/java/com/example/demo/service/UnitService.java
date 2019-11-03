package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Unit;
import com.example.demo.repository.UnitRepository;

@Service
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;

	public Unit save(final Unit unit) {
		return unitRepository.save(unit);
	}

	public Unit findByName(final String name) {
		return unitRepository.findByName(name);
	}

	public List<Unit> findAll() {

		return (List<Unit>) unitRepository.findAll();
	}

}
