package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	
	@GetMapping("/greet")
	public ModelAndView getGreeTmessage() {
		ModelAndView modelAndView = new ModelAndView();
		// Setting response data in K-V
		modelAndView.addObject("message", "Good Morning to all...");
		// Setting view page name
		modelAndView.setViewName("index");
		return modelAndView;

	}
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMessage() {
		ModelAndView modelAndView = new ModelAndView();
		// Setting response data in K-V
		modelAndView.addObject("message", "Welcome to WebMVC...");
		// Setting view page name
		modelAndView.setViewName("index");
		return modelAndView;

	}
}
