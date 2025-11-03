package com.rajabhay.app;

import java.io.File;

import com.rajabhay.bindings.Customer;

import tools.jackson.databind.ObjectMapper;

public class MyApp {

	public void convertJavaToJson() {
		File file = new File("customer.json");
		Customer customer = new Customer();
		customer.setCuid(100);
		customer.setName("Abhay");
		customer.setMobNum("9224356299");
		customer.setCountry("India");

		// serialization
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(file, customer);
		
		System.out.println("Operation completed...");

	}
	
	public void convertJsonToJava() {
		File file = new File("customer.json");
		// de-serialization
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer = objectMapper.readValue(file, Customer.class);
		
		System.out.println(customer);
		
	}
	
	public static void main(String[] args) {
		MyApp app = new MyApp();
		//app.convertJavaToJson();
		app.convertJsonToJava();
	}
}
