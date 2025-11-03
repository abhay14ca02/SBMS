package com.rajabhay.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		String message = "Welcome to SpringBoot REST API App!";

		return message;
	}

	@GetMapping("/greet")
	public ResponseEntity<String> getGreetMessage() {
		String message = "Good Morning...!!";
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping(value = "/welcomemesg", produces = "text/plain")
	public String getWelcomeMesg() {
		String message = "Welcome to SpringBoot REST API App!!";

		return message;
	}

	@GetMapping(value = "/greetmesg", produces = "text/plain")
	public ResponseEntity<String> getGreetMesg() {
		String message = "Good Morning...!!!";
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
}
