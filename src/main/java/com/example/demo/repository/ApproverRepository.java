package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Approver;

@Repository
public interface ApproverRepository extends CrudRepository<Approver, Long> {

	public Approver findByUserNameAndLevel(final String userName,final Long level);
}

