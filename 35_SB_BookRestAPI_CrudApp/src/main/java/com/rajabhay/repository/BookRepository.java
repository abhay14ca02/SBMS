package com.rajabhay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.bindings.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByName(String name);

	public List<Book> findByAuthorName(String authorName);

}
