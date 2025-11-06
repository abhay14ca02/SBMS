package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.rajabhay.bindings.Quote;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		getRandomQuote();

		getRandomQuote2();

		getRandomQuote3();

	}

	private static void getRandomQuote() {
		String apiUrl = "https://dummyjson.com/quotes/random";

		WebClient webClient = WebClient.create();
		Mono<String> bodyToMono = webClient.get().uri(apiUrl).retrieve().bodyToMono(String.class);
		// Making Synchronous call
		String block = bodyToMono.block();
		System.out.println(block);
	}

	private static void getRandomQuote2() {
		String apiUrl = "https://dummyjson.com/quotes/random";

		WebClient webClient = WebClient.create();
		Mono<Quote> bodyToMono = webClient.get().uri(apiUrl).retrieve().bodyToMono(Quote.class);
		// Making Synchronous call
		Quote block = bodyToMono.block();
		System.out.println(block);
	}

	private static void getRandomQuote3() {
		String apiUrl = "https://dummyjson.com/quotes/random";

		WebClient webClient = WebClient.create();
		// 1
		System.out.println("======= Request sending - start  =======");
		// Making Asynchronous call
		webClient.get().uri(apiUrl).retrieve().bodyToMono(Quote.class).subscribe(response -> {
			handleResponse(response); // 2
		});

		// 3
		System.out.println("==== Request sending - completed ======");
	}

	private static void handleResponse(Quote response) {
		System.out.println(response);
		// push response to kafka server
	}

}
