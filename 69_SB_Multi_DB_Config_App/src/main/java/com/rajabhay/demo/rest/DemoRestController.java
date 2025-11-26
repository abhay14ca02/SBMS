package com.rajabhay.demo.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.book.entity.Book;
import com.rajabhay.book.repo.BookRepository;
import com.rajabhay.user.entity.UserInfo;
import com.rajabhay.user.repo.UserRepository;

@RestController
public class DemoRestController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/addData")
	public String addData2DB() {
		userRepository.saveAll(Stream.of(new UserInfo(744, "John"), new UserInfo(455, "Smith")).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
		return "Data Added Successfully";
	}

	@GetMapping("/getUsers")
	public List<UserInfo> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}