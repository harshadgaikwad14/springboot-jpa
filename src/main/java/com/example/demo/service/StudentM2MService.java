package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentM2M;
import com.example.demo.repository.StudentM2MRepository;

@Service
public class StudentM2MService {

	@Autowired
	private StudentM2MRepository studentM2MRepository;

	public StudentM2M save(final StudentM2M studentM2M) {
		return studentM2MRepository.save(studentM2M);
	}
	
	public StudentM2M findById(final Long id) {
		return studentM2MRepository.findById(id).get();
	}
	


}
