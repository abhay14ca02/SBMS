package com.rajabhay.daoimpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rajabhay.dao.IBookDao;
import com.rajabhay.dto.BookDTO;
import com.rajabhay.mapper.BookRowMapper;

public class BookDaoImpl implements IBookDao {

	private JdbcTemplate jdbcTemplate;

	private static final String SQL_INSERT_QUERY = "insert into WBOOKS values(?, ?, ?, ?)";

	private static final String SQL_GET_QUERY = "select * from WBOOKS";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveBook(BookDTO bookDTO) {

		jdbcTemplate.update(SQL_INSERT_QUERY, ps -> {

			ps.setString(1, bookDTO.getId());
			ps.setString(2, bookDTO.getBookName());
			ps.setString(3, bookDTO.getAuthorName());
			ps.setString(4, bookDTO.getPrice());

		});
	}

	@Override
	public List<BookDTO> getBooks() {
		List<BookDTO> bookLists = jdbcTemplate.query(SQL_GET_QUERY, new BookRowMapper());
		return bookLists;
	}

}
