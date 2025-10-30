package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
