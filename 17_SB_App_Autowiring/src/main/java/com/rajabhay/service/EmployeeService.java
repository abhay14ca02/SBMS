package com.rajabhay.service;

import org.springframework.stereotype.Service;

import com.rajabhay.dao.EmployeeDao;

@Service
public class EmployeeService {

	// ICO will create object by using Field Injection because of Reflection API.
	// Even though we define Variable as private
	/*
	 * // FI
	 * 
	 * @Autowired private EmployeeDao employeeDao;
	 */

	/*
	 * // SI
	 * 
	 * @Autowired public void setEmployeeDao(EmployeeDao employeeDao) {
	 * System.out.println("Setter Injection..."); this.employeeDao = employeeDao; }
	 */

	/*
	 * @Autowired public EmployeeService(EmployeeDao employeeDao) {
	 * System.out.println("Constructor Injection..."); this.employeeDao =
	 * employeeDao; }
	 */

	// preferable to use Constructor Injection, if Java class does not have 0 -
	// param Constructor then no need to give @Autowired annotation at Constructor,
	// as IOC will
	// call param Constructor to create object.

	private EmployeeDao employeeDao;

	public EmployeeService(EmployeeDao employeeDao) {
		System.out.println("Constructor Injection...");
		this.employeeDao = employeeDao;
	}

	public void saveEmployee() {

		employeeDao.saveEmployee();
	}
}
