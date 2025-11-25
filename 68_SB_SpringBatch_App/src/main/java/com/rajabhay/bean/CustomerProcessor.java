package com.rajabhay.bean;

import org.springframework.batch.infrastructure.item.ItemProcessor;

import com.rajabhay.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {

		// final String fname = item.getFirstName().toUpperCase();
		// final String lname = item.getLastName().toUpperCase();

		// final Customer transformedCustomer = new Customer(fname,lname);

		return item;
	}

}
