package com.rajabhay.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.controller.BookController;

public class MyApp {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("Beans.xml");
		ConfigurableApplicationContext cactxt = (ConfigurableApplicationContext) ctxt;
		BookController bookController = ctxt.getBean(BookController.class);
		bookController.getBooks();
		cactxt.close();

	}
}
