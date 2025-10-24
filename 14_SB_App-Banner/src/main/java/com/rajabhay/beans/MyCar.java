package com.rajabhay.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCar {

	public MyCar() {
		System.out.println("MyCar :: Constructor");
	}

	@Bean
	MyCar start() {
		System.out.println("MyCar started...");
		return new MyCar();
	}
}
