package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.UserService;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Spring-Beans.xml");
		UserService userService = ctxt.getBean(UserService.class);
		userService.userRegistration();
		ConfigurableApplicationContext cactxt = (ConfigurableApplicationContext) ctxt;
		cactxt.close();
	}
}
