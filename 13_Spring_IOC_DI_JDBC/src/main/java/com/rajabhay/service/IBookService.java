package com.rajabhay.service;

import java.util.List;

import com.rajabhay.dto.BookDTO;

public interface IBookService {

	public void saveBook(BookDTO bookDTO);

	public List<BookDTO> getBooks();
}
