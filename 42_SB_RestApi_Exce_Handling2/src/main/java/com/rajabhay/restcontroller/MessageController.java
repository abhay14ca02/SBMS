package com.rajabhay.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		int i = 10 / 0; // AE

		String msg = "Welcome to Rest API...!";
		return msg;
	}

	@GetMapping("/greet")
	public String getGreetMsg() {

		String s = null;
		s.length(); // NPE

		String msg = "Good Morning...!";
		return msg;
	}
}
