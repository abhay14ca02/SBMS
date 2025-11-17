package com.rajabhay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.client.WelcomeFeignClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeFeignClient welcomeClient;

	@GetMapping("/greet")
	public String greetMessage() {

		String welcomeMsg = welcomeClient.invokeWelcomeMsg();
		String greetMsg = "Good Morning, ";

		return greetMsg + welcomeMsg;
	}
}
