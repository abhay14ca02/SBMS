package com.rajabhay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Address_info")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer addrId;
	private String city;
	private String state;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="Emp_Id")
	private Employee employee;
	
}
