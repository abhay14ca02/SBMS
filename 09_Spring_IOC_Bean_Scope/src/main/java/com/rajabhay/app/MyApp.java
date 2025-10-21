package com.rajabhay.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.ATM;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
		ATM atm = context.getBean(ATM.class);
		ATM atm1 = context.getBean(ATM.class);
		System.out.println("Atm ::" + atm.hashCode());
		System.out.println("Atm1 ::" + atm1.hashCode());
		atm.withdraw();
		ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) context;
		applicationContext.close();
	}
}
