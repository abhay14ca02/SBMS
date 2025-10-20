package com.rajabhay.beans;

public class UserService {

	private PwdService pwdService;

	public UserService() {
		System.out.println("UserService:: 0 - param Constructor");
	}

	// CI
	public UserService(PwdService pwd) {
		System.out.println("UserService:: param Constructor");
		this.pwdService = pwd;
	}

	// SI
	public void setPwdService(PwdService pwdService) {
		System.out.println("setPwdService() -- called..");
		this.pwdService = pwdService;
	}

	public void saveUser(String userName, String pwd, Long phoneNo) {

		String encodedPwd = pwdService.encodePwd(pwd);
		System.out.println("Encoded pwd :: " + encodedPwd);
		// ToDo:: Insert into DB
		System.out.println("Record inserted in DB");

	}
}
