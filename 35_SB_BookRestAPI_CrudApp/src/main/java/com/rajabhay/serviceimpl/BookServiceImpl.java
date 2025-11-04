package com.rajabhay.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajabhay.bindings.Book;
import com.rajabhay.repository.BookRepository;
import com.rajabhay.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository repository;

	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public Book getBook(Integer bid) {
		Optional<Book> byId = repository.findById(bid);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> all = repository.findAll();
		return all;
	}

	@Override
	public String upsert(Book book) {
		if (book.getBid() != null && repository.existsById(book.getBid())) {
		    repository.save(book);
		    return "Book updated in db...";
		} else {
		    repository.save(book);
		    return "Book saved in db...";
		}
	}

	@Override
	public String deleteBook(Integer bid) {
		boolean existsById = repository.existsById(bid);
		if (existsById) {
			repository.deleteById(bid);
			return "Book deleted from db...";
		}
		return "Book not deleted from db...";
	}

	@Override
	public List<Book> findByName(String name) {
		List<Book> books = repository.findByName(name);
		return books;
	}

	@Override
	public List<Book> findByAuthorName(String authorName) {
		List<Book> books = repository.findByAuthorName(authorName);
		return books;
	}
}
