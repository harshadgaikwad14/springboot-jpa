package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Grade;
import com.example.demo.repository.GradeRepository;

@Service
public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	public Grade save(final Grade grade) {
		return gradeRepository.save(grade);
	}

	public Grade findByName(final String name) {
		return gradeRepository.findByName(name);
	}

	public List<Grade> findAll() {

		return (List<Grade>) gradeRepository.findAll();
	}

}
