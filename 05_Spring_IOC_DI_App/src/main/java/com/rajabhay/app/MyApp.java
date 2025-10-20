package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.Restaurant;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Restaurant restaurant = context.getBean(Restaurant.class);
		restaurant.bill();
	}
}
