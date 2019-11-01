package com.example.demo.service;

import java.util.ArrayList;
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
		List<Privilege> privileges = new ArrayList<>();
		final Iterable<Privilege> iterator = privilegeRepository.findAll();
		for (Privilege privilege : iterator) {
			privileges.add(privilege);
		}
		
		return privileges;
	}

}
