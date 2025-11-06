package com.rajabhay.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajabhay.entity.Ticket;
import com.rajabhay.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public String bookTicket(Ticket ticket) {

		Ticket savedTicket = ticketRepository.save(ticket);

		if (savedTicket.getTicketId() != null) {
			return "Ticket booked successfully. Ticket Number : " + savedTicket.getTicketId();
		} else {
			return "Ticket not booked";
		}

	}

	@Override
	public List<Ticket> getTickets() {
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets;
	}
}
