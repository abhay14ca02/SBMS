package com.rajabhay.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.rajabhay.pojo.Books;

public class BookService {

	private BookDAO bookDAO;

	public BookService() {
		System.out.println("BookService :: Constructor");
	}

	public void setBookDAO(BookDAO dao) {
		System.out.println("setBookDAO() called...");
		this.bookDAO = dao;
	}

	public void saveBook() throws IOException {
		File f = new File("Books.txt");

		FileReader fr = new FileReader(f);

		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();

		while (line != null) {

			String[] data = line.split(",");

			String id = data[0];
			String name = data[1];
			String author = data[2];
			String price = data[3];
			Books book = new Books();
			book.setId(id);
			book.setBookName(name);
			book.setAuthorName(author);
			book.setPrice(price);
			// insert into db
			String message = bookDAO.saveBook(book);
			System.out.println(message);
			// read linext line
			line = br.readLine();
		}
		br.close();
	}
}
