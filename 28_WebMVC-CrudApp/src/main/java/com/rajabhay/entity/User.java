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
import lombok.Data;

@Data
@Entity
@Table(name = "UserInfo_Tbl")
public class User {

	@Id
	@Column(name = ("User_Id"))
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;

	private String userName;

	private String email;

	private String mobileNum;

	private String city;

	private String state;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedAt;
}
