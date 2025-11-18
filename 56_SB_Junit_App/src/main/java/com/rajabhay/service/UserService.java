package com.rajabhay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajabhay.dao.UserDao;
import com.rajabhay.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean saveUser(User user) {
		userDao.saveUser(user);
		return true;
	}

	public String findName(Integer id) {
		System.out.println(userDao.getClass().getName());

		String name = userDao.findName(id);

		System.out.println("Name :: " + name);
		
		return name;
	}
}
