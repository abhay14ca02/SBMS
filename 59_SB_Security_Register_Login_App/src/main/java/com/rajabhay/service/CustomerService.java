package com.rajabhay.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.Customer;
import com.rajabhay.repo.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {

	private CustomerRepository customerRepo;

	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	public boolean saveCustomer(Customer customer) {

		Customer savedCustomer = customerRepo.save(customer);

		return savedCustomer.getCid() != null;

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer cust = customerRepo.findByEmail(email);

		return new User(cust.getEmail(), cust.getPwd(), Collections.emptyList());

	}
}
