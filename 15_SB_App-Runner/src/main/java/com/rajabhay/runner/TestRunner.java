package com.rajabhay.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner{

	public TestRunner() {
		System.out.println("TestRunner :: Constructor");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner - run() called........");
		// Load Country Code static data from db to cache memory
		
	}
}
