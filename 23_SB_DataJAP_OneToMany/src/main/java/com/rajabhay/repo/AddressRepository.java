package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
