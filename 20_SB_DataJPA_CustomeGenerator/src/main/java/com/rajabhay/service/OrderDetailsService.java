package com.rajabhay.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.OrderDetails;
import com.rajabhay.repo.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	private OrderDetailsRepository detailsRepo;

	@Autowired
	public void setDetailsRepo(OrderDetailsRepository detailsRepo) {

		this.detailsRepo = detailsRepo;
	}

	public void saveOrderDetails() {
		OrderDetails details = new OrderDetails();
		details.setOrderBy("David");
		details.setOrderPlacedDate(new Date());
		System.out.println("Before saving..." + details);
		details = detailsRepo.save(details);
		System.out.println("After saving..." + details);
	}
}
