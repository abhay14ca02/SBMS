package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.service.EmployeeAdressService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeAdressService bean = context.getBean(EmployeeAdressService.class);
		// bean.saveData();
		// bean.deleteEmpployee();
		// bean.getEmployee();
		bean.getAddress();

	}

}
