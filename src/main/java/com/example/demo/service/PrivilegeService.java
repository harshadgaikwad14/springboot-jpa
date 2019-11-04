package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Privilege;
import com.example.demo.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	public Privilege save(final Privilege privilege) {
		return privilegeRepository.save(privilege);
	}
	
	public Privilege findByName(final String privilegeName) {
		return privilegeRepository.findByName(privilegeName);
	}

	public List<Privilege> findAll() {
		return (List<Privilege>) privilegeRepository.findAll();
	}

	public void delete(final Privilege privilege) {
		privilegeRepository.delete(privilege);
	}

	public Privilege findById(final Long id) {
		return privilegeRepository.findById(id).get();
	}

	public List<Privilege> findAll(final Long id) {
		return (List<Privilege>) privilegeRepository.findAll();
	}

	public List<Privilege> findAllById(final List<Long> ids) {
		return (List<Privilege>) privilegeRepository.findAllById(ids);
	}


}
