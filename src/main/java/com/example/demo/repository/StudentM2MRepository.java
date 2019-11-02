package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentM2M;

@Repository
public interface StudentM2MRepository extends CrudRepository<StudentM2M, Long> {

}

