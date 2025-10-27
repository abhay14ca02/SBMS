package com.rajabhay.repo;

import org.springframework.data.repository.CrudRepository;

import com.rajabhay.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
