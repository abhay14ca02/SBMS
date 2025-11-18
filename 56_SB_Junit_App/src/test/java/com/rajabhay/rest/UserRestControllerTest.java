package com.rajabhay.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajabhay.model.User;
import com.rajabhay.service.UserService;

@WebMvcTest(value = UserRestController.class)
public class UserRestControllerTest {

	@MockitoBean
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveUserTestCase1() throws Exception {

		// Define moc obj method behaviour

		when(userService.saveUser(any(User.class))).thenReturn(true);

		User user = new User();
		user.setId(101);
		user.setName("Abhay");
		user.setEmail("abc@gmail.com");

		// Converting Java object to JSON Object
		ObjectMapper objectMapper = new ObjectMapper();
		String userJson = objectMapper.writeValueAsString(user);

		// prepare POST request to /user url
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
				.contentType("application/json").content(userJson);

		// send POST request using MockMVC bean
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		// get response from result and validate it
		MockHttpServletResponse response = mvcResult.getResponse();

		int actualStatus = response.getStatus();

		int expectedStatus = 201;

		assertEquals(expectedStatus, actualStatus);

	}

	@Test
	public void testSaveUserTestCase2() throws Exception {

		// Define moc obj method behaviour

		when(userService.saveUser(any())).thenReturn(false);

		User user = new User();
		user.setId(101);
		user.setName("Abhay");
		user.setEmail("abc@gmail.com");

		// Converting Java object to JSON Object
		ObjectMapper objectMapper = new ObjectMapper();
		String userJson = objectMapper.writeValueAsString(user);

		// prepare POST request to /user url
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
				.contentType("application/json").content(userJson);

		// send POST request using MockMVC bean
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		// get response from result and validate it
		MockHttpServletResponse response = mvcResult.getResponse();

		int actualStatus = response.getStatus();

		int expectedStatus = 500;

		assertEquals(expectedStatus, actualStatus);

	}
}
