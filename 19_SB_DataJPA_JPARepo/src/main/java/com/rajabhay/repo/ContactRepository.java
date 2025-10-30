package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.ContactInfo;

public interface ContactRepository extends JpaRepository<ContactInfo, Integer>{

}
