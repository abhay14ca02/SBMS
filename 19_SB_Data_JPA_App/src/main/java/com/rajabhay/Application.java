package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rajabhay.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = context.getBean(UserService.class);
		// userService.deleteUsers();
		// userService.deleteById(1815);
		// userService.saveUser();
		// userService.saveUsers();
		// userService.getUserById(1005);
		// userService.getUsers();
		// userService.getUsersById(Arrays.asList(1008, 1009, 1815, 1003, 1007));
		// userService.getUsersByCountry("USA");
		// userService.getUsersByCountryAndGender("India", "Male");
		// userService.getUsersCount();
		// userService.userExist(1008);
		// userService.getAllUsersHQL();
		// userService.getAllUsersSQL();
		// userService.updateCityById("Bangalore", 1009);
		// userService.deleteUserById(1006);
		userService.saveUserBySQL(1121, "Rahuk", "Male", "India", "Nalanda");
	}

}
