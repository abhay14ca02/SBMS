package com.rajabhay.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.Passport;
import com.rajabhay.entity.Person;
import com.rajabhay.repo.PassportRepository;
import com.rajabhay.repo.PersonRepository;

@Service
public class PersonPassportService {

	private PersonRepository personRepo;

	private PassportRepository passportRepo;

	public PersonPassportService(PersonRepository personRepo, PassportRepository passportRepo) {

		this.passportRepo = passportRepo;
		this.personRepo = personRepo;
	}

	public void saveData() {
		Person person = new Person();
		person.setPersonName("Smith");
		person.setGender("Male");
		Person savedPerson = personRepo.save(person);

		Passport passport = new Passport();

		passport.setPassportNum("TRBC68686D");
		passport.setIssuedAt(LocalDate.now());
		passport.setExpireAt(LocalDate.now().plusYears(10));

		passport.setPerson(savedPerson);

		passportRepo.save(passport);
	}

	public void deletePerson() {
		personRepo.deleteById(1);
		System.out.println("Person deleted...");
	}

	public void getPerson() {
		Optional<Person> byId = personRepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

	public void deletePassport() {
		passportRepo.deleteById(2);
		System.out.println("Passport deleted...");
	}

	// left join
	public void getPassport() {
		Optional<Passport> byId = passportRepo.findById(2);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}
}
