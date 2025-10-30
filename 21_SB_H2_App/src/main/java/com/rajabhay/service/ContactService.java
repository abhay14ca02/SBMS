package com.rajabhay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.Contact;
import com.rajabhay.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;

	public void saveContact() {

		Contact contact = new Contact();
		contact.setName("Raju");
		contact.setEmail("raju@gmail.com");
		contact.setPhoneNum("9876543210");

		System.out.println("Before saving : " + contact);

		Contact savedEntity = contactRepo.save(contact);

		System.out.println("After saving:" + savedEntity);
	}
}
