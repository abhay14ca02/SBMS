package com.rajabhay.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
@ResponseBody
public class UserController {

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/simple-email")
	public String sendEmail() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo("rajabhay50@gmail.com");
		message.setSubject("Welcome to SpringBoot Email Sending App");
		message.setText("This is email body for testing");
		mailSender.send(message);
		return "Email sent successfully!";
	}
	
	@GetMapping("/mime-email")
	public String sendMimeEmail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		
		messageHelper.setTo("rajabhay50@gmail.com");
		messageHelper.setSubject("Welcome to SpringBoot Email Sending App");
		messageHelper.setText("<h1>This is email body for testing</h1>", true);
		messageHelper.addAttachment("Image", new File("file-path"));
		mailSender.send(mimeMessage);
		
		return "Email sent successfully!";
	}
}
