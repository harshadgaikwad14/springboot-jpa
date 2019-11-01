package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role save(final Role role) {
		return roleRepository.save(role);
	}

	public Role findByName(final String roleName) {
		return roleRepository.findByName(roleName);
	}

	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		final Iterable<Role> iterator = roleRepository.findAll();
		for (Role role : iterator) {
			roles.add(role);
		}
		
		return roles;
	}

}
