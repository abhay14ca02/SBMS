package com.rajabhay.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.Role;
import com.rajabhay.entity.User;
import com.rajabhay.repo.RoleRepository;
import com.rajabhay.repo.UserRepository;

@Service
public class UserRoleService {

	private UserRepository userRepo;

	private RoleRepository roleRepo;

	public UserRoleService(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	public void saveUserWithRoles() {

		Role r1 = new Role();
		r1.setRoleName("Manager");

		Role r2 = new Role();
		r2.setRoleName("Admin");

		User user = new User();
		user.setUserName("Abhay");
		user.setGender("Male");
		user.setUserEmail("abc.25@email.com");
		user.setUserDob(LocalDate.now().minusYears(20));

		user.setRoles(Arrays.asList(r1, r2));

		userRepo.save(user);

	}

	public void getUser(int id) {
		Optional<User> findById = userRepo.findById(id);
		if (findById.isPresent()) {
			System.out.println(findById.get());
		}

	}

	public void getRole(int id) {
		Optional<Role> findById = roleRepo.findById(id);
		if (findById.isPresent()) {
			System.out.println(findById.get());
		}

	}
}
