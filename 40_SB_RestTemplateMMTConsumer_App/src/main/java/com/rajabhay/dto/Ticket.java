package com.rajabhay.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Ticket {

	private Long ticketId;
	@NotEmpty(message = "Passenger Name is mandatory")
	private String passengerName;
	@NotNull(message = "Age is mandatory")
	private Integer age;
	@NotEmpty(message = "Email is mandatory")
	private String email;
	@NotEmpty(message = "Gender is mandatory")
	private String gender;
	@NotEmpty(message = "From Station is mandatory")
	private String fromStation;
	@NotEmpty(message = "To Station is mandatory")
	private String toStation;
	@NotNull(message = "Travel Date is mandatory")
	private LocalDate travelDate;
	@NotEmpty(message = "Train Number is mandatory")
	private String trainNumber;
}
