package com.rajabhay.model;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String mobileNum;
}
