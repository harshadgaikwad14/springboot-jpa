package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SubjectM2M;

@Repository
public interface SubjectM2MRepository extends CrudRepository<SubjectM2M, Long> {

}

