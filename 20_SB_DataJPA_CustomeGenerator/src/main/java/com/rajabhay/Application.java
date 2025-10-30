package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.service.OrderDetailsService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		OrderDetailsService detailsService = context.getBean(OrderDetailsService.class);
		detailsService.saveOrderDetails();
	}

}
