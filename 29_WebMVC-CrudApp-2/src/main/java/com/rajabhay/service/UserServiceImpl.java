package com.rajabhay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.User;
import com.rajabhay.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser.getUserId() != null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> all = userRepository.findAll();
		return all;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		boolean existsById = userRepository.existsById(userId);
		if (existsById) {
			userRepository.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> byId = userRepository.findById(userId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

}
