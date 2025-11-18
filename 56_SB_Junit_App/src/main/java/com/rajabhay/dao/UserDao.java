package com.rajabhay.dao;

import org.springframework.stereotype.Repository;

import com.rajabhay.model.User;

@Repository
public class UserDao {

	public boolean saveUser(User user) {
		// DB logic
		return true;
	}

	public String findName(Integer uid) {
		return "Abhay";
	}
}
