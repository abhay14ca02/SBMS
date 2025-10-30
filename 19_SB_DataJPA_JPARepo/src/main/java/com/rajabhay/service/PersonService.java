package com.rajabhay.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.Person;
import com.rajabhay.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepo;

	public PersonService(PersonRepository personRepo) {

		this.personRepo = personRepo;
	}

	public void savePersons() {
		List<Person> listOfPersons = List.of(new Person(101, "Ranjan", 47, "Male", "Nalanda", "India"),
				new Person(102, "Adarsh", 17, "Male", "Bhopal", "India"),
				new Person(103, "Anjali", 21, "Female", "Bhopal", "India"),
				new Person(104, "Nirbhay", 34, "Male", "Mumbai", "India"),
				new Person(105, "Abhay", 36, "Male", "Bangalore", "India"),
				new Person(106, "David", 44, "Male", "London", "UK"),
				new Person(107, "Aish", 50, "Female", "NY", "USA"),
				new Person(108, "Sonali", 30, "Female", "Mumbai", "India"),
				new Person(109, "Rahul", 29, "Male", "Bangalore", "India"),
				new Person(110, "Anup", 27, "Male", "Bangalore", "India"));
		personRepo.saveAll(listOfPersons);
		System.out.println("Records saved successfully...");
	}

	// Sort
	public void getPersonsSort() {
		Sort ascending = Sort.by("age").ascending();
		List<Person> all = personRepo.findAll(ascending);
		all.forEach(person -> {
			System.out.println(person);
		});
	}

	// Pagination
	public void getPersonsPagination() {
		int pageSize = 3; // fixed value
		int pageNo = 1; // comes from UI
		PageRequest request = PageRequest.of(pageNo - 1, pageSize);
		Page<Person> all = personRepo.findAll(request);
		List<Person> content = all.getContent();
		content.forEach(System.out::println);
	}

	// QBE
	public void getPersonsQBE(String gender, String country) {
		Person p = new Person();
		if (gender != null) {
			p.setGender(gender);
		}
		if (country != null) {
			p.setCountry(country);
		}
		Example<Person> of = Example.of(p);
		List<Person> all = personRepo.findAll(of);
		all.forEach(System.out::println);

	}

}
