package com.rajabhay.dao;

import java.util.List;

import com.rajabhay.dto.BookDTO;

public interface IBookDao {

	public void saveBook(BookDTO bookDTO);

	public List<BookDTO> getBooks();
}
