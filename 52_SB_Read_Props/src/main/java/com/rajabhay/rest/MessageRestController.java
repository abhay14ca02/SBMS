package com.rajabhay.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.appprops.AppProperties;

@RestController
public class MessageRestController {

	@Value("${msg}")
	private String msg;
	
	@Autowired
	private AppProperties appProperties;

	@GetMapping("/msg")
	public String getMessage() {
		return msg;
	}
	
	@GetMapping("/greet")
	public String greetGetMessage() {
		Map<String, String> messages = appProperties.getMessages();
		return messages.get("greet_msg");
	}
	
	@GetMapping("/welcome")
	public String greetWelcomeMessage() {
		
		Map<String, String> messages = appProperties.getMessages();
		return messages.get("welcome_msg");
	}
}
