package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project save(final Project approver) {
		return projectRepository.save(approver);
	}
	
	public Project findByName(final String name) {
		return projectRepository.findByName(name);
	}
	


}
