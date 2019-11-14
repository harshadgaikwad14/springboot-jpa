package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Module;
import com.example.demo.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public Module save(final Module module) {
		return moduleRepository.save(module);
	}

	public Module findByName(final String name) {
		return moduleRepository.findByName(name);
	}

	public List<Module> findAll() {

		return (List<Module>) moduleRepository.findAll();
	}

}
