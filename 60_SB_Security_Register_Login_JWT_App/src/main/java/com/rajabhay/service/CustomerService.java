package com.rajabhay.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.Customer;
import com.rajabhay.repo.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepo;

	public boolean saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer.getCuid() != null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer cust = customerRepo.findByUsername(username);

		return new User(cust.getUsername(), cust.getPwd(), Collections.emptyList());
	}

}
