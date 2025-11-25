package com.rajabhay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Customer_Tbl")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	private Integer cuid;
	private String username;
	private String email;
	private String mobno;
	private String pwd;
}
