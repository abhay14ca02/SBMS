package com.rajabhay.eception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	/*
	 * @ExceptionHandler(value = Exception.class) public ResponseEntity<String>
	 * handleException(Exception exception) {
	 * 
	 * return new ResponseEntity<String>(exception.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	/*
	 * @ExceptionHandler(value = { ArithmeticException.class,
	 * NullPointerException.class }) public ResponseEntity<String>
	 * handleException(Exception exception) {
	 * 
	 * return new ResponseEntity<String>(exception.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	/*
	 * @ExceptionHandler(value = NullPointerException.class) public
	 * ResponseEntity<String> handleNPException(NullPointerException npe) {
	 * 
	 * return new ResponseEntity<String>(npe.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	/*
	 * @ExceptionHandler(value = ArithmeticException.class) public
	 * ResponseEntity<String> handleAException(ArithmeticException ae) {
	 * 
	 * return new ResponseEntity<String>(ae.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	/*
	 * @ExceptionHandler(value = Exception.class) public ResponseEntity<ExeInfo>
	 * handleException(Exception e) { String message = e.getMessage(); ExeInfo
	 * exeInfo = new ExeInfo(); exeInfo.setExCode("EX500");
	 * exeInfo.setExMsg(message); exeInfo.setExDate(LocalDateTime.now());
	 * 
	 * return new ResponseEntity<>(exeInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ExeInfo> handleNPException(NullPointerException npe) {
		String message = npe.getMessage();
		ExeInfo exeInfo = new ExeInfo();
		exeInfo.setExCode("EX500");
		exeInfo.setExMsg(message);
		exeInfo.setExDate(LocalDateTime.now());

		return new ResponseEntity<>(exeInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<ExeInfo> handleAException(ArithmeticException ae) {
		String message = ae.getMessage();
		ExeInfo exeInfo = new ExeInfo();
		exeInfo.setExCode("EX501");
		exeInfo.setExMsg(message);
		exeInfo.setExDate(LocalDateTime.now());

		return new ResponseEntity<>(exeInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ExeInfo> handleProductEx(ProductNotFoundException e) {

		String message = e.getMessage();
		ExeInfo exeInfo = new ExeInfo();
		exeInfo.setExCode("EX79797");
		exeInfo.setExMsg(message);
		exeInfo.setExDate(LocalDateTime.now());

		return new ResponseEntity<>(exeInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
