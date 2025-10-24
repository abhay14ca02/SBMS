package com.rajabhay.excelgenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rajabhay.dto.BookDTO;

public class ExcelGenerator {

	public void excelGenerator(List<BookDTO> books) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Books");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Book Id");
		headerRow.createCell(1).setCellValue("Book Name");
		headerRow.createCell(2).setCellValue("Author Name");
		headerRow.createCell(3).setCellValue("Price");
		int dataRowIndex = 1;
		for (BookDTO dto : books) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(dto.getId());
			dataRow.createCell(1).setCellValue(dto.getBookName());
			dataRow.createCell(2).setCellValue(dto.getAuthorName());
			dataRow.createCell(3).setCellValue(dto.getPrice());
			dataRowIndex++;
		}
		FileOutputStream fos = new FileOutputStream("Books.xlsx");
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}
