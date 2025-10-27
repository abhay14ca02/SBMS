package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.entity.Employee;
import com.rajabhay.repo.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cactxt = SpringApplication.run(Application.class, args);
		// Implementation class is provided by DAT JPA internally, if EmployeeRepository
		// extends DATA JPA repository
		EmployeeRepository employeeRepo = cactxt.getBean(EmployeeRepository.class);
		System.out.println("Impl class :: " + employeeRepo.getClass().getName());
		Employee emp = new Employee();
		emp.setEmpId(1902);
		emp.setEmpName("Ayansh");
		emp.setCompanyName("Dell");
		emp.setEmpSalary(200000.00);
		employeeRepo.save(emp);
		System.out.println("Employee data saved...");
	}

}
