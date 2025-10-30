package com.rajabhay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person_info")
public class Person {

	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String city;
	private String country;
}
