package com.rajabhay.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.bindings.Book;
import com.rajabhay.serviceimpl.BookServiceImpl;

@RestController
public class BookRestController {

	private BookServiceImpl serviceImpl;

	public BookRestController(BookServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;

	}

	@GetMapping(value = "/book/{bid}", produces = "application/json")
	public ResponseEntity<Book> getBook(@PathVariable Integer bid) {
		Book book = serviceImpl.getBook(bid);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping(value = "/books", produces = "application/json")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = serviceImpl.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping(value = "/books/{name}", produces = "application/json")
	public ResponseEntity<List<Book>> getBooksByName(@PathVariable String name) {
		List<Book> list = serviceImpl.findByName(name);
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/booksauthor/{authorName}", produces = "application/json")
	public ResponseEntity<List<Book>> getBooksByAuthorName(@PathVariable String authorName) {
		List<Book> list = serviceImpl.findByAuthorName(authorName);
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/book", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		String savedBook = serviceImpl.upsert(book);
		return new ResponseEntity<String>(savedBook, HttpStatus.CREATED);
	}

	@PutMapping(value = "/book", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String updatedBook = serviceImpl.upsert(book);
		return new ResponseEntity<String>(updatedBook, HttpStatus.OK);
	}

	@DeleteMapping(value = "/book/{bid}", produces = "text/plain")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bid) {
		String deleteBook = serviceImpl.deleteBook(bid);
		return new ResponseEntity<String>(deleteBook, HttpStatus.OK);
	}

}
