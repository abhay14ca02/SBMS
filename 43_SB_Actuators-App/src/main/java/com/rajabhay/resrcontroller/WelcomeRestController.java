package com.rajabhay.resrcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {

		String message = "Welcome to Spring Boot Actuators";
		return message;
	}
}
