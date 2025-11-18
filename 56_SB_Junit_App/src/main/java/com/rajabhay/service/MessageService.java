package com.rajabhay.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	public String getWelcomeMsg() {
		String msg = "Welcome to Junit Testing App...";
		return msg;
	}

	public String getGreetMsg() {
		String msg = "Good Morning..!!";
		return msg;
	}
}
