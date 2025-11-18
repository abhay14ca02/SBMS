package com.rajabhay.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.rajabhay.service.MessageService;

@WebMvcTest(value = MessageRestController.class)
public class MessageRestControllerTest {

	@MockitoBean
	private MessageService messageService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcomeMsg() throws Exception {

		// Define moc obj method behaviour

		when(messageService.getWelcomeMsg()).thenReturn("Welcome to Junit Testing...");

		// prepare GET request to /welcome url

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

		// send GET request using MockMVC bean

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		// get response from result and validate it

		MockHttpServletResponse response = mvcResult.getResponse();

		String actualResult = response.getContentAsString();

		String expectedResult = "WELCOME TO JUNIT TESTING...";

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testGreetMsg() throws Exception {

		// Define moc obj method behaviour

		when(messageService.getGreetMsg()).thenReturn("Good Evening...");

		// prepare GET request to /greet url

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");

		// send GET request using MockMVC bean

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		// get response from result and validate it

		MockHttpServletResponse response = mvcResult.getResponse();

		int actualStatus = response.getStatus();

		int expectedStatus = 200;

		assertEquals(expectedStatus, actualStatus);
	}
}
