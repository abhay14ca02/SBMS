package com.rajabhay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.service.MessageService;

@RestController
public class MessageRestController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/welcome")
	public String getWelcomeMessage() {

		System.out.println(messageService.getClass().getName());
		
		String welcomeMsg = messageService.getWelcomeMsg();
		welcomeMsg = welcomeMsg.toUpperCase();
		return welcomeMsg;
	}
	
	@GetMapping("/greet")
	public String getGreetMessage() {
		
		System.out.println(messageService.getClass().getName());
		
		String greetMsg = messageService.getGreetMsg();
		greetMsg = greetMsg.toLowerCase();
		return greetMsg;
	}
}
