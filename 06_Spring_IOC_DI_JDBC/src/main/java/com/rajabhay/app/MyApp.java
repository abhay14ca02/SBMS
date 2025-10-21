package com.rajabhay.app;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajabhay.beans.BookService;

public class MyApp {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BookService bookService = context.getBean(BookService.class);
		bookService.saveBook();
	}
}
