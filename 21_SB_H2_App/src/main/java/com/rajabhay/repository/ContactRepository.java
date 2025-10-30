package com.rajabhay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
