package com.rajabhay.service;

import java.util.List;

import com.rajabhay.entity.User;

public interface UserService {

	public boolean saveUser(User info);

	public List<User> getAllUsers();

	public User getUserById(Integer uid);

	public boolean deleteUserById(Integer uid);
}
