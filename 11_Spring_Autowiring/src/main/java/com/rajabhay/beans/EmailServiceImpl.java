package com.rajabhay.beans;

public class EmailServiceImpl implements IEmailService {

	@Override
	public void sendEmail() {
		System.out.println("Email sent to user");
	}

}
