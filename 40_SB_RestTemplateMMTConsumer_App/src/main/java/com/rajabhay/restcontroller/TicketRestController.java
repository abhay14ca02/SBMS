package com.rajabhay.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rajabhay.dto.Ticket;
import com.rajabhay.service.TicketService;

import jakarta.validation.Valid;

@Controller
public class TicketRestController {

	@Autowired
	private TicketService service;

	@GetMapping("/ticket")
	public String loadForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "bookTicket";
	}

	@PostMapping("/ticket")
	public String bookTicket(@Valid Ticket ticket, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "bookTicket";
		}
		String bookTicket = service.bookTicket(ticket);
		model.addAttribute("successmsg", bookTicket);
		// Important: re-add a fresh user object for the form
		model.addAttribute("ticket", new Ticket());
		return "bookTicket";

	}

	@GetMapping(value = "/tickets", produces = "application/json")
	public String displayTickets(Model model) {
		List<Ticket> tickets = service.getTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}
}
