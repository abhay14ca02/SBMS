package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.Motor;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Spring-Beans.xml");
		Motor motor = ctxt.getBean(Motor.class);
		motor.doWork();
		ConfigurableApplicationContext catxt = (ConfigurableApplicationContext) ctxt;
		//Closing IOC
		catxt.close();
	}
}
