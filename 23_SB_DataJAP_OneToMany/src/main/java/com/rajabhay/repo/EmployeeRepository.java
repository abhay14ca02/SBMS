package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
