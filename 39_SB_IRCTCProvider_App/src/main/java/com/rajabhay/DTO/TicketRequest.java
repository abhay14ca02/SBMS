package com.rajabhay.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketRequest {

	private String passengerName;
	private Integer age;
	private String email;
	private String gender;
	private String fromStation;
	private String toStation;
	private LocalDate travelDate;
	private String trainNumber;
}
