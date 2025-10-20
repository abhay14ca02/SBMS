package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.DiselEngine;
import com.rajabhay.beans.PetrolEngine;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		// It is used to start the IOC container by giving xml file as an Input
		DiselEngine de = ctx.getBean(DiselEngine.class);
		de.start();
		PetrolEngine pe = ctx.getBean(PetrolEngine.class);
		pe.start();
		
	}
}
