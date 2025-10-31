package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public ModelAndView getWelcomeMessage() {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("message", "Welcome to SpringBoot WebMVC!");

		modelAndView.setViewName("index");
		
		return modelAndView;

	}

	@GetMapping("/greet")
	public String getGreetMessage(Model model) {
		String messageTxt = "Good Morning to all!";

		model.addAttribute("message",messageTxt);
		
		return "index";
	}
	
	@GetMapping("/demo")
	@ResponseBody
	public String getDemoMessage() {
		return "This is for demo msg";
	}
}
