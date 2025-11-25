package com.rajabhay.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		String welMsg = "Welcome to Spring Security App...";
		return welMsg;
	}

	@GetMapping("/greet")
	public String getGreetessage() {
		String welMsg = "Good Morning...";
		return welMsg;
	}

	@GetMapping("/contact")
	public String getContactInfo() {
		return "Contact No." + "+91 9898 89 90";
	}
}
