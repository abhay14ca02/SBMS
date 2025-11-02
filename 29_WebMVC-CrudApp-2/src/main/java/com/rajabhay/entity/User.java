package com.rajabhay.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "User_Tbl")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;

	@NotEmpty(message = "UserName is mandatory")
	private String userName;

	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Enter a valid email")
	private String email;

	@NotEmpty(message = "Mobile number is mandatory")
	private String mobileNum;

	@NotEmpty(message = "City is mandatory")
	private String city;

	@NotEmpty(message = "State is mandatory")
	private String state;

	@NotNull(message = "Pin Code is mandatory")
	private Integer pinCode;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedAt;
}
