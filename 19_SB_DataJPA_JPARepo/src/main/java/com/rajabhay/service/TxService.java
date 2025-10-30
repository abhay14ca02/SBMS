package com.rajabhay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajabhay.entity.ContactInfo;
import com.rajabhay.entity.Person;
import com.rajabhay.repo.ContactRepository;
import com.rajabhay.repo.PersonRepository;

@Service
public class TxService {

	@Autowired
	private ContactRepository contactRepo;

	@Autowired
	private PersonRepository personRepo;

	@Transactional(rollbackFor = Exception.class)
	public void savePersonWithContact() {
		Person person = new Person();

		person.setId(1007);
		person.setName("Malan");
		person.setAge(32);
		person.setGender("Male");
		person.setCity("London");
		person.setCity("UK");

		personRepo.save(person);
		
		int num = 10/0;

		ContactInfo contact = new ContactInfo();
		
		contact.setName("Raj");
		contact.setEmailId("raj@gmail.com");
		contact.setPhoneNo("1234567890");
		
		contactRepo.save(contact);
	}
}
