package com.rajabhay.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Passport_Info")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer passportId;
	private String passportNum;
	private LocalDate issuedAt;
	private LocalDate expireAt;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	
}
