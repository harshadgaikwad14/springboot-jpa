package com.example.demo.service;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.Project;


public class ProjectSpecification {

	public static Specification<Project> eqActive(final boolean active) {
		return (root, query, cb) -> {
			return cb.equal(root.get("active"), active);
		};
	}

	/*
	 * public static Specification<Project> subDivision() { return (root, query, cb)
	 * -> { return cb.lessThan(root.get(Movie_.createdAt), new
	 * LocalDate.now().minusYears(25)); }; }
	 */

	public static Specification<Project> eqSubDivisionName(final String subDivisionName) {
		return (root, query, cb) -> {
			return cb.equal(root.get("subDivisionName"), subDivisionName);
		};
	}
	
	public static Specification<Project> orderByAddress() {
		return (root, query, cb) -> {
			query.orderBy(cb.asc(root.get("address")));
			return cb.conjunction();
		};
	}
	
	public static Specification<Project> likeAddressOrSubDivisionContains(String address,String subDivisionName) {
        return (root, query, cb) -> {
            final String containsLikePattern1 = getContainsLikePattern(address);
            final String containsLikePattern2 = getContainsLikePattern(subDivisionName);
            return cb.and(
                    cb.like(cb.lower(root.<String>get("address")), containsLikePattern1),
                    cb.like(cb.lower(root.<String>get("subDivisionName")), containsLikePattern2)
            );
        };
    }
	
	private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }

}
