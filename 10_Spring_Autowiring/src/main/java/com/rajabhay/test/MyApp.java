package com.rajabhay.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.ATM;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Spring-Beans.xml");
		ATM atm = ctxt.getBean(ATM.class);
		atm.withdraw();
		ConfigurableApplicationContext cactx = (ConfigurableApplicationContext) ctxt;
		cactx.close();
	}
}
