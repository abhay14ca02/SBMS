package com.rajabhay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.model.User;
import com.rajabhay.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) {

		boolean saveUser = userService.saveUser(user);
		if (saveUser) {
			sendEmail();
			return new ResponseEntity<String>("User saved...", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("User not saved...", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public String sendEmail() {
		return "Email sent to user...";
	}
}
