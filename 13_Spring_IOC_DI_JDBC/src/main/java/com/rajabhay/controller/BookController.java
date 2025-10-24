package com.rajabhay.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.rajabhay.dto.BookDTO;
import com.rajabhay.excelgenerator.ExcelGenerator;
import com.rajabhay.pdfgenerator.PdfGenerator;
import com.rajabhay.service.IBookService;

public class BookController {

	private IBookService bookService;
	private ExcelGenerator excelGenerator;
	private PdfGenerator pdfGenerator;

	public BookController(IBookService bookService, ExcelGenerator excelGenerator, PdfGenerator pdfGenerator) {
		this.bookService = bookService;
		this.excelGenerator = excelGenerator;
		this.pdfGenerator = pdfGenerator;
	}

	public void storeBookData() throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.txt"));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] data = line.split(",");
			BookDTO bookDTO = new BookDTO();
			bookDTO.setId(data[0]);
			bookDTO.setBookName(data[1]);
			bookDTO.setAuthorName(data[2]);
			bookDTO.setPrice(data[3]);
			bookService.saveBook(bookDTO);
		}
		System.out.println("Records saved successfully...");
		bufferedReader.close();
	}

	public void getBooks() throws IOException {
		List<BookDTO> bookLists = bookService.getBooks();
		excelGenerator.excelGenerator(bookLists);
		pdfGenerator.pdfGenerator(bookLists);
		bookLists.forEach(book -> {
			System.out.println(book);
		});
	}
}
