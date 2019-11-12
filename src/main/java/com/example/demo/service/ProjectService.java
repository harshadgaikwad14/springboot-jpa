package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

	public List<Project> findAll(final boolean isActive, final int pageNo, final int pageSize, final String sortBy) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Project> pagedResult = projectRepository.findByActive(isActive, paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Project>();
		}
	}

	public List<Project> findAll(final int pageNo, final int pageSize, final String sortBy) {

		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Project> pagedResult = projectRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Project>();
		}
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

	public List<Project> findAllGroupBySort() {
		Sort nameSort = Sort.by("name");
		Sort activeSort = Sort.by("active");

		Sort groupBySort = nameSort.and(activeSort);

		return (List<Project>) projectRepository.findAll(groupBySort);
	}

	public void findBySubDivisionName(final String subDivisionName, final int pageNo, final int pageSize) {
		PageRequest paging = PageRequest.of(pageNo, pageSize);

		Page<Project> pageResult = projectRepository.findBySubDivisionName(subDivisionName, paging);

		System.out.println("************* slicedResult ****************");

		List<Project> employeeList = pageResult.getContent();
		for (Project project : employeeList) {
			System.out.println(project);
		}

		System.out.println("pageResult.getTotalPages() : " + pageResult.getTotalPages());
		System.out.println("pageResult.getTotalElements() : " + pageResult.getTotalElements());
		System.out.println("pageResult.getNumber() : " + pageResult.getNumber());
		System.out.println("pageResult.getNumberOfElements() : " + pageResult.getNumberOfElements());
		System.out.println("pageResult.getSize() : " + pageResult.getSize());
		System.out.println("pageResult.hasNext() : " + pageResult.hasNext());
		System.out.println("pageResult.hasPrevious() : " + pageResult.hasPrevious());
		System.out.println("pageResult.isFirst() : " + pageResult.isFirst());
		System.out.println("pageResult.isLast() : " + pageResult.isLast());
		System.out.println("pageResult.getPageable().getOffset() : " + pageResult.getPageable().getOffset());
		System.out.println("pageResult.getPageable().getPageNumber() : " + pageResult.getPageable().getPageNumber());
		System.out.println("pageResult.getPageable().getPageSize() : " + pageResult.getPageable().getPageSize());

	}

	public void testJPASpecification() {
		PageRequest paging = PageRequest.of(0, 10);
		List<Long> ids = new ArrayList<>();
		for (long i = 1; i <=20; i++) {
			ids.add(i);
		}
		List<Project> projects1 = projectRepository.findIn(ids,paging);
		for (Project project : projects1) {
			System.out.println("findIn >> "+project);
		}
		System.out.println("************ queryIn 8*************88");
		List<Project> projects2 = projectRepository.queryIn(ids,paging);
		for (Project project : projects2) {
			System.out.println("queryIn >> "+project);
		}
		
		
		final Specification<Project> spec = ProjectSpecification.eqActive(true).or(ProjectSpecification.eqSubDivisionName("Div1"));
		Page<Project> projects3 =projectRepository.findAll(spec, paging);
		for (Project project : projects3) {
			System.out.println("findAllwith spec >> "+project);
		}
		
		final Specification<Project> spec2 = ProjectSpecification.likeAddressOrSubDivisionContains("Mumbai1", "Div");
		Page<Project> projects4 =projectRepository.findAll(spec2, paging);
		for (Project project : projects4) {
			System.out.println("likeAddressOrSubDivisionContains spec >> "+project);
		}
		
		
	}

}
