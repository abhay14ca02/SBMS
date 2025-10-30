package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
}

