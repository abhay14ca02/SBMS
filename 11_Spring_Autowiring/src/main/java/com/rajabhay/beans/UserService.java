package com.rajabhay.beans;

public class UserService {

	private IPwdService pwdService;
	private IEmailService emailService;
	private IuserDao userDao;

	public UserService() {
		System.out.println("UserService 0 - Param Constructor...");
	}

	public UserService(IPwdService pwdService, IEmailService emailService, IuserDao dao) {
		System.out.println("UserService - Params Constructor...");
		this.pwdService = pwdService;
		this.emailService = emailService;
		this.userDao = dao;
	}

	public void userRegistration() {
		
		pwdService.generatePwd();
		userDao.saveUser();
		emailService.sendEmail();
		
		System.out.println("**** user registration success **");
	}
}
