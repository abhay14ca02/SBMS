package com.rajabhay.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rajabhay.dto.BookDTO;

public class BookRowMapper implements RowMapper<BookDTO> {

	@Override
	public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		BookDTO dto = new BookDTO();
		dto.setId(rs.getString(1));
		dto.setBookName(rs.getString(2));
		dto.setAuthorName(rs.getString(3));
		dto.setPrice(rs.getString(4));
		return dto;
	}

}
