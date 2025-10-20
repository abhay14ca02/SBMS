package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.Car;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Car car = context.getBean(Car.class);
		car.drive();
	}
}
