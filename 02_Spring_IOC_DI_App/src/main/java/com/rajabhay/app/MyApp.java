package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.UserService;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Bean.xml");
		UserService userService = ctx.getBean(UserService.class);
		userService.saveUser("Abhay", "abhay123", 123456l);
	}

}
