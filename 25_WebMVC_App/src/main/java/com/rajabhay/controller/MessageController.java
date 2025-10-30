package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	@GetMapping("/greet")
	public ModelAndView getGreetMessage() {
		ModelAndView modelAndView = new ModelAndView();
		// Setting response data in K-V (Key - Value)
		modelAndView.addObject("message", "Good Morning to all...");
		// setting view page name
		modelAndView.setViewName("index");

		return modelAndView;

	}

	@GetMapping("/welcome")
	public ModelAndView getWelcomeMessage() {

		ModelAndView modelAndView = new ModelAndView();
		// Setting response data in K-V (Key - Value)
		modelAndView.addObject("message", "Welcome to WebMVC...");
		// setting view page name
		modelAndView.setViewName("index");

		return modelAndView;

	}
}
