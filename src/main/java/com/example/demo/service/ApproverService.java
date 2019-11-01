package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Approver;
import com.example.demo.repository.ApproverRepository;

@Service
public class ApproverService {

	@Autowired
	private ApproverRepository approverRepository;

	public Approver save(final Approver approver) {
		return approverRepository.save(approver);
	}
	
	public Approver findByUserNameAndLevel(final String userName,final Long level) {
		return approverRepository.findByUserNameAndLevel(userName, level);
	}
	


}
