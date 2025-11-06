package com.rajabhay.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TrainTicket_Tbl")
public class Ticket {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TrainTicket_Id")
	private Long ticketId;
	private String passengerName;
	private Integer age;
	private String email;
	private String gender;
	private String fromStation;
	private String toStation;
	private LocalDate travelDate;
	private String trainNumber;
}
