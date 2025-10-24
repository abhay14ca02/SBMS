package com.rajabhay.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	public MyRunner() {
		System.out.println("MyRunner :: Constructor");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("cmdRunner - run() called........");
		// Load Country Code static data from db to cache memory
		 // read countries table data and store into cache memory

	}
}
