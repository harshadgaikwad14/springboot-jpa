package com.example.demo.service;

import java.util.List;

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

	public Approver findByUserNameAndLevel(final String userName, final Long level) {
		return approverRepository.findByUserNameAndLevel(userName, level);
	}

	public void delete(final Approver approver) {
		approverRepository.delete(approver);
	}

	public Approver findById(final Long id) {
		return approverRepository.findById(id).get();
	}

	public List<Approver> findAll(final Long id) {
		return (List<Approver>) approverRepository.findAll();
	}

	public List<Approver> findAll(final List<Long> ids) {
		return (List<Approver>) approverRepository.findAllById(ids);
	}

}
