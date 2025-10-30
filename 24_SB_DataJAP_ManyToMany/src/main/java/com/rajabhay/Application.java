package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.service.UserRoleService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserRoleService bean = context.getBean(UserRoleService.class);
		bean.saveUserWithRoles();
		//bean.getUser(1);
		//bean.getRole(1);
	}

}
