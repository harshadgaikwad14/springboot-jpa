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

	public void delete(final Grade grade) {
		gradeRepository.delete(grade);
	}

	public Grade findById(final Long id) {
		return gradeRepository.findById(id).get();
	}

	public List<Grade> findAll(final Long id) {
		return (List<Grade>) gradeRepository.findAll();
	}

	public List<Grade> findAllById(final List<Long> ids) {
		return (List<Grade>) gradeRepository.findAllById(ids);
	}

}
