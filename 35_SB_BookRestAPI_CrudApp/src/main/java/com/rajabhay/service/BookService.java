package com.rajabhay.service;

import java.util.List;

import com.rajabhay.bindings.Book;

public interface BookService {
	public List<Book> findByName(String name);

	public List<Book> findByAuthorName(String authorName);

	public Book getBook(Integer bid);

	public List<Book> getAllBooks();

	public String upsert(Book book);

	public String deleteBook(Integer bid);
}
