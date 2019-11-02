package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SubjectM2M;
import com.example.demo.repository.SubjectM2MRepository;

@Service
public class SubjectM2MService {

	@Autowired
	private SubjectM2MRepository subjectM2MRepository;

	public SubjectM2M save(final SubjectM2M subjectM2M) {
		return subjectM2MRepository.save(subjectM2M);
	}
	
	public SubjectM2M findById(final Long id) {
		return subjectM2MRepository.findById(id).get();
	}
	


}
