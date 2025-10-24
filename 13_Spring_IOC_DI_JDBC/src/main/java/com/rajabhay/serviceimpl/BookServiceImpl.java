package com.rajabhay.serviceimpl;

import java.util.List;

import com.rajabhay.dao.IBookDao;
import com.rajabhay.dto.BookDTO;
import com.rajabhay.service.IBookService;

public class BookServiceImpl implements IBookService {

	private IBookDao bookDao;

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void saveBook(BookDTO bookDTO) {
		bookDao.saveBook(bookDTO);
	}

	@Override
	public List<BookDTO> getBooks() {
		List<BookDTO> bookLists = bookDao.getBooks();

		return bookLists;
	}

}
