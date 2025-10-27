package com.rajabhay.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_INFO") // optional
public class User {

	@Id
	@Column(name = "user_id") // optional
	private Integer id;
	private String userName;
	private String gender;
	private String city;
	private String country;

	@CreationTimestamp // populate record created date
	@Column(updatable = false) // It will not update value in lastUpdatedDate, when we create a record.
	private LocalDate createdDate;

	@UpdateTimestamp // populate record updated date
	@Column(insertable = false) // It will not insert value in createdDate, when we update a record.
	private LocalDate lastUpdatedDate;
}
