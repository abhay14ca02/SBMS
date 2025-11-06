package com.rajabhay.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajabhay.dto.Ticket;
import com.rajabhay.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Override
	public String bookTicket(Ticket ticket) {
		String apiUrl = "http://localhost:8080/api/ticket";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Ticket> entity = new HttpEntity<>(ticket, headers);
		ResponseEntity<String> postForEntity = restTemplate.postForEntity(apiUrl, entity, String.class);
		return postForEntity.getBody();

	}

	@Override
	public List<Ticket> getTickets() {
		String apiUrl = "http://localhost:8080/api/tickets";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket[]> response = restTemplate.getForEntity(apiUrl, Ticket[].class);
		List<Ticket> tickets = Arrays.asList(response.getBody());
		return tickets;
	}
}