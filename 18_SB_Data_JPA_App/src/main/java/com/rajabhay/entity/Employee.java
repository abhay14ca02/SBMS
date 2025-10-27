package com.rajabhay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Info")
public class Employee {

	@Id
	private Integer empId;
	private String empName;
	private String companyName;
	private Double empSalary;
}
