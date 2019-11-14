package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectRepository
		extends PagingAndSortingRepository<Project, Long>, JpaSpecificationExecutor<Project> {

	public Project findByName(final String name);

	public Page<Project> findByActive(final boolean active, Pageable pageable);

	public Page<Project> findBySubDivisionName(final String subDivisionName, Pageable pageable);

	@Query("select p from Project p where p.id in :ids")
	List<Project> queryIn(@Param("ids") List<Long> ids, Pageable pageable);

	List<Project> findByIdIn(List<Long> ids, Pageable pageable);

	public Page<Project> findAll(Specification<Project> spec, Pageable pageable);

	default List<Project> findIn(List<Long> ids, Pageable pageable) {
		return findAll((root, criteriaQuery, criteriaBuilder) -> {
			if (ids.isEmpty()) {
				return null; // or criteriaBuilder.conjunction()
			} else {
				return root.get("id").in(ids);
			}
		});
	}
}
