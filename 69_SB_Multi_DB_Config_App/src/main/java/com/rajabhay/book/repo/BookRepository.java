package com.rajabhay.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
