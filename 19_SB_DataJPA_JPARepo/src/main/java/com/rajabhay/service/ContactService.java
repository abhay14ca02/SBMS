package com.rajabhay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.ContactInfo;
import com.rajabhay.repo.ContactRepository;

@Service
public class ContactService {

	// FI
	@Autowired
	private ContactRepository contactRepo;

	public void savContactInfo() {
		ContactInfo info = new ContactInfo();
		info.setName("Abhay");
		info.setEmailId("abhay@gmail.com");
		info.setPhoneNo("9223256299");
		System.out.println("Before saving to DB..." + info);
		info = contactRepo.save(info);
		System.out.println("After saving to DB..." + info);
	}

}
