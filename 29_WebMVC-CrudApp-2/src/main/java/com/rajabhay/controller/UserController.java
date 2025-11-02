package com.rajabhay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajabhay.entity.User;
import com.rajabhay.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String loadForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "index";

	}

	@PostMapping("/user")
	public String handleSubmit(@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";
		}

		boolean isSaved = userService.saveUser(user);
		if (isSaved) {
			model.addAttribute("successmsg", "User saved");
		} else {
			model.addAttribute("errormsg", "User Not Saved");
		}
		// Important: re-add a fresh user object for the form
		model.addAttribute("user", new User());
		return "index";

	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("users", allUsers);
		return "users";
	}

	@GetMapping("/edit-user")
	public String editUser(@RequestParam Integer userId, Model model) {
		User userById = userService.getUserById(userId);
		model.addAttribute("user", userById);
		return "index";

	}

	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam Integer userId, Model model) {

		boolean status = userService.deleteUserById(userId);
		if (status) {
			model.addAttribute("successmsg", "User deleted");
			List<User> allUsers = userService.getAllUsers();
			model.addAttribute("users", allUsers);
		} else {
			model.addAttribute("errormsg", "User not deleted");
		}
		return "users";

	}
}
