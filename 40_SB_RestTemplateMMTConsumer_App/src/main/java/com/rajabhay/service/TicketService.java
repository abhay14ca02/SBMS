package com.rajabhay.service;

import java.util.List;

import com.rajabhay.dto.Ticket;

public interface TicketService {

	public String bookTicket(Ticket ticket);

	public List<Ticket> getTickets();
}
