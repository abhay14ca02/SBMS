package com.rajabhay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		String apiUrl = "http://localhost:8080/welcome";

		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("abc", "abc@123");

		HttpEntity<String> reqEntity = new HttpEntity<String>(headers);

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> resEntity = rt.exchange(apiUrl, HttpMethod.GET, reqEntity, String.class);

		System.out.println(resEntity.getBody());
	}

}
