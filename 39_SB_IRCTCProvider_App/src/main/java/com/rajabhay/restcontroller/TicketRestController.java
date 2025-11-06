package com.rajabhay.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.DTO.TicketRequest;
import com.rajabhay.entity.Ticket;
import com.rajabhay.service.TicketService;

@RestController
public class TicketRestController {

	private TicketService ticketService;

	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping(value = "/api/ticket", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> bookTicket(@RequestBody TicketRequest request) {

		Ticket ticket = new Ticket();
		ticket.setPassengerName(request.getPassengerName());
		ticket.setAge(request.getAge());
		ticket.setEmail(request.getEmail());
		ticket.setGender(request.getGender());
		ticket.setTrainNumber(request.getTrainNumber());
		ticket.setFromStation(request.getFromStation());
		ticket.setToStation(request.getToStation());
		ticket.setTravelDate(LocalDate.now());
		String bookTicket = ticketService.bookTicket(ticket);

		return new ResponseEntity<String>(bookTicket, HttpStatus.CREATED);

	}

	@GetMapping(value = "/api/tickets", produces = "application/json")
	public ResponseEntity<List<Ticket>> getTickets() {

		List<Ticket> tickets = ticketService.getTickets();

		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}
}
