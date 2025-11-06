package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rajabhay.bindings.Quote;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		getWelcomeMessage();

		getRandomQuote();

	}

	private static void getWelcomeMessage() {
		String apiURL = "https://api.restful-api.dev/objects/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(apiURL, String.class);
		System.out.println(forEntity.getStatusCode().value());
		System.out.println(forEntity.getBody());
	}

	private static void getRandomQuote() {
		String apiURL = "https://dummyjson.com/quotes/random";
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> forEntity = restTemplate.getForEntity(apiURL, String.class);
		ResponseEntity<Quote> forEntity = restTemplate.getForEntity(apiURL, Quote.class);
		System.out.println(forEntity.getStatusCode().value());
		System.out.println(forEntity.getBody());
		
	}

}
