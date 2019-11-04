package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project save(final Project project) {
		return projectRepository.save(project);
	}

	public Project findByName(final String name) {
		return projectRepository.findByName(name);
	}

	public List<Project> findAll() {
		return (List<Project>) projectRepository.findAll();
	}

	public void delete(final Project project) {
		projectRepository.delete(project);
	}

	public Project findById(final Long id) {
		return projectRepository.findById(id).get();
	}

	public List<Project> findAll(final Long id) {
		return (List<Project>) projectRepository.findAll();
	}

	public List<Project> findAllById(final List<Long> ids) {
		return (List<Project>) projectRepository.findAllById(ids);
	}

}
