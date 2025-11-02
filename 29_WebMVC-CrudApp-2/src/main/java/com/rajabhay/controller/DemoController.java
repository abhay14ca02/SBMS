package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@GetMapping("/greet/{name}")
	@ResponseBody
	public String greetMessage(@PathVariable String name) {

		return name + ", This is greet message";
	}

	@GetMapping("/greet")
	@ResponseBody
	public String greetWelcome(@RequestParam String name) {
		return name + ", This is welcome message";

	}
}
