package com.rajabhay.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.rajabhay.dao.UserDao;
import com.rajabhay.model.User;

@SpringBootTest
@ExtendWith(value = { MockitoExtension.class })
public class UserServiceTest {

	@MockitoBean
	private UserDao userDao;

	@InjectMocks
	private UserService userService;

	@Test
	public void testsaveUser() {

		when(userDao.saveUser(any())).thenReturn(true);

		User user = new User();
		user.setId(101);
		user.setName("Ayansh");
		user.setEmail("ayansh@gmail.com");

		boolean actual = userService.saveUser(user);

		assertTrue(actual);
	}

	@Test
	public void testGetName() {
		
		when(userDao.findName(101)).thenReturn("Mohan");
		when(userDao.findName(102)).thenReturn("Raja");
		
		String name = userService.findName(101);
		
		assertNotNull(name);
	}
}
