package com.rajabhay.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.User;
import com.rajabhay.repo.UserRepository;
import com.rajabhay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean saveUser(User info) {
		User savedUser = repository.save(info);
		return savedUser.getUserId() != null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = repository.findAll();
		return allUsers;
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> byId = repository.findById(userId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		boolean existsById = repository.existsById(userId);
		if (existsById) {
			repository.deleteById(userId);
			return true;
		}
		return false;
	}

}
