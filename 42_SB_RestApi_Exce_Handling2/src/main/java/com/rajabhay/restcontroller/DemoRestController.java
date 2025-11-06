package com.rajabhay.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/demo")
	public String getDemoMessage() {
		String str = null;
		int len = str.length();
		String msg = "Welcome to REST API Exception...!";
		return msg;
	}
}
