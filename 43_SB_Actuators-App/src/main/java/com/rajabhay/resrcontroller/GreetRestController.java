package com.rajabhay.resrcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@GetMapping("/greet")
	public String getGreetMessage() {
		String message = "Good Morning...!";
		return message;
	}
}
