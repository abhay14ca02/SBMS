package com.rajabhay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rajabhay.DTO.QuoteResponse;
import com.rajabhay.bindings.Quote;

@Service
public class QuoteService {

	private final RestTemplate restTemplate = new RestTemplate();

	public List<Quote> getQuotes() {
		String apiURL = "https://dummyjson.com/quotes";
		QuoteResponse quoteResponse = restTemplate.getForObject(apiURL, QuoteResponse.class);

		return quoteResponse != null ? quoteResponse.getQuotes() : new ArrayList<>();
	}
}
