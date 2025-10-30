package com.rajabhay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String>{

}
