package com.rajabhay.service;

import java.util.List;

import com.rajabhay.entity.User;

public interface UserService {

	public boolean saveUser(User user);

	public List<User> getAllUsers();

	public boolean deleteUserById(Integer userId);

	public User getUserById(Integer userId);
}
