package com.rajabhay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.User;
import com.rajabhay.repo.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	// No need to add @Autowired annotation, because we don't have any no - arg
	// Constructor.
	// So, IOC will call it for Bean/Object creation.
	public UserService(UserRepository repository) {
		this.userRepo = repository;
		System.out.println("Repo Impl class :" + userRepo.getClass().getName());
	}

	public void deleteUsers() {
		try {
			userRepo.deleteAll();
			System.out.println("Users deleted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			userRepo.deleteById(id);
			System.out.println("One user deleted...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveUser() {
		System.out.println("Inside saveUser() method");
		User user = new User();
		user.setId(1815);
		user.setUserName("Aadya");
		user.setGender("Female");
		user.setCity("Bangalore");
		user.setCountry("India");
		try {
			userRepo.save(user);
			System.out.println("User saved...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveUsers() {
		System.out.println("Inside saveUsers() method");
		List<User> listOfUsers = List.of(new User(1003, "XYZ", "Male", "NYC", "USA", null, null),
				new User(1004, "Malan", "Male", "London", "UK", null, null),
				new User(1005, "David", "Male", "London", "UK", null, null),
				new User(1006, "Vincent", "Female", "NYC", "USA", null, null),
				new User(1007, "Pamela", "Female", "NYC", "USA", null, null),
				new User(1008, "Amit", "Male", "Patna", "India", null, null),
				new User(1009, "Anup", "Male", "Nalanda", "India", null, null));

		try {
			userRepo.saveAll(listOfUsers);
			System.out.println("Users saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getUserById(Integer id) {
		Optional<User> byId = userRepo.findById(id);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		} else {
			System.out.println("No record found...");
		}
	}

	public void getUsers() {
		Iterable<User> all = userRepo.findAll();
		// Lambda expression
		all.forEach(user -> {
			System.out.println(user);
		});
	}

	public void getUsersById(List<Integer> ids) {

		Iterable<User> allById = userRepo.findAllById(ids);
		// Method reference
		allById.forEach(System.out::println);
	}

	public void getUsersByCountry(String country) {

		List<User> byCountry = userRepo.findByCountry(country);

		byCountry.forEach(user -> {
			System.out.println(user);
		});
	}

	public void getUsersByCountryAndGender(String country, String gender) {

		List<User> byCountryAndGender = userRepo.findByCountryAndGender(country, gender);
		byCountryAndGender.forEach(System.out::println);
	}

	public void getUsersCount() {
		try {
			long count = userRepo.count();
			System.out.println("Number of users :: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void userExist(Integer id) {
		try {
			boolean existsById = userRepo.existsById(id);
			if (existsById) {
				System.out.println("User exists...");
			} else {
				System.out.println("User does not exist...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllUsersHQL() {
		List<User> allUsersHQL = userRepo.getAllUsersHQL();
		allUsersHQL.forEach(user -> {
			System.out.println(user);
		});
	}

	public void getAllUsersSQL() {
		List<User> allUsersSQL = userRepo.getAllUsersSQL();
		allUsersSQL.forEach(user -> {
			System.out.println(user);
		});
	}

	public void updateCityById(String city, Integer id) {
		Optional<User> byId = userRepo.findById(id);
		if (byId.isPresent()) {
			userRepo.updateCityById(city, byId.get().getId());
			System.out.println("One User updated with Id : " + id);
		} else {
			System.out.println("No user updated...");
		}
	}

	public void deleteUserById(Integer id) {
		Optional<User> byId = userRepo.findById(id);
		if (byId.isPresent()) {
			userRepo.deleteUserById(byId.get().getId());
			System.out.println("One User deleted with Id : " + id);
		} else {
			System.out.println("No user deleted...");
		}
	}

	public void saveUserBySQL(Integer id, String name, String gender, String city, String country) {
		userRepo.saveUserBySQL(id, name, gender, city, country);
		System.out.println("User saved successfully...");
	}
}
