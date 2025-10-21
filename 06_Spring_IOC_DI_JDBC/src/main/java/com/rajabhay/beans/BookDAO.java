package com.rajabhay.beans;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rajabhay.pojo.Books;

public class BookDAO {
	private JdbcTemplate jdbcTemplate;

	public BookDAO() {
		System.out.println("BookDAO :: Constructor...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String saveBook(Books book) {
		String SQL = "insert into WBOOKS (id, bookName, authorName, price) values (?, ?, ?, ?)";
		String id = book.getId();
		String bookName = book.getBookName();
		String authorName = book.getAuthorName();
		String price = book.getPrice();
		jdbcTemplate.update(SQL, id, bookName, authorName, price);
		return "Book saved in db";
	}

}
