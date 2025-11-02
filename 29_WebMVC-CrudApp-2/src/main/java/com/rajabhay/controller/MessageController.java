package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/message")
public class MessageController {

	@GetMapping("/demo")
	@ResponseBody
	public String getMessage() {

		return "This is welcome message.";
	}

	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		
		String msgTxt  = "Good Morning";
		model.addAttribute("msg", msgTxt);
		
		return "welcome";
	}

	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		
		ModelAndView mav = new ModelAndView();

		// setting response data in K-V
		mav.addObject("msg", "Welcome to Web MVC");
		// setting view page name
		mav.setViewName("welcome");

		return mav;
	}
}
