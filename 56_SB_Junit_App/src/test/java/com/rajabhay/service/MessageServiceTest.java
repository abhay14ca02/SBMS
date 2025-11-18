package com.rajabhay.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(value = { MockitoExtension.class })
public class MessageServiceTest {

	@InjectMocks
	private MessageService messageService;

	@Test
	public void testWelcomeMsg() {
		String welcomeMsg = messageService.getWelcomeMsg();
		assertNotNull(welcomeMsg);
	}

	
	@Test
	public void testGreetMsg() {
		String greetMsg = messageService.getGreetMsg();
		assertNotNull(greetMsg);
	}
}
