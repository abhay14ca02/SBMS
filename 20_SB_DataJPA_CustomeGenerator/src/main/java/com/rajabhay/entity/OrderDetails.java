package com.rajabhay.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Order_Details")
public class OrderDetails {

	@SuppressWarnings("deprecation")
	@Id
	@Column(name = "Order_Id")
	@GenericGenerator(name = "order_id_gen", strategy = "com.rajabhay.generator.OrderIdGenerator")
	@GeneratedValue(generator = "order_id_gen")
	private String orderId;
	@Column(name = "Order_By")
	private String orderBy;
	@Column(name = "Order_Placed_Date")
	private Date orderPlacedDate;
}
