package com.rajabhay.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Book_Tbl")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	private Integer id;
	private String name;
}
