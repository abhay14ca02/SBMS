package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rajabhay.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/")
	public String loadForm(Model model) {

		User userObj = new User();
		model.addAttribute("user", userObj);
		return "index";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, User user, Model model) {
		String email = user.getEmail();
		String password = user.getPassword();

		if (email.equals("abc@gmail.com") && password.equals("abc")) {

			// creating session object
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("email", email);

			return "dashboard";
		} else {
			// invalid login
			model.addAttribute("errormsg", "Invalid Credentials");
		}
		return "index";

	}

	@GetMapping("/personal-details")
	@ResponseBody
	public String getPersonalDetails(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		// get user personal data based on email
		return email + " :: persona-details-page";
	}

	@GetMapping("/edu-details")
	@ResponseBody
	public String getEduDetails(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		// get user educational data based on email
		return email + " :: educational-details-page";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		
		User userObj = new User();
		model.addAttribute("user", userObj);

		HttpSession session = request.getSession(false);
		
		session.invalidate();

		return "index";
	}
}
