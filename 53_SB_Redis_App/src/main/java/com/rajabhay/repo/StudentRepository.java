package com.rajabhay.repo;

import org.springframework.data.repository.CrudRepository;

import com.rajabhay.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
