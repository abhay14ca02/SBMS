package com.rajabhay.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		int i = 10 / 0; // AE

		String msg = "Welcome to Rest API...";
		return msg;
	}

	@GetMapping("/greet")
	public String getGreetMsg() {
		String str = null;

		int len = str.length(); // NPE

		String msg = "Good Morning...!";
		return msg;
	}

	/*
	 * @ExceptionHandler(value = Exception.class) public String
	 * handleException(Exception exception) {
	 * 
	 * return exception.getMessage(); }
	 */

	/*
	 * @ExceptionHandler(value = { NullPointerException.class,
	 * ArithmeticException.class }) public String handleException(Exception
	 * exception) { return exception.getMessage(); }
	 */

	/*
	 * @ExceptionHandler(value = Exception.class) public ResponseEntity<String>
	 * handleException(Exception exception) {
	 * 
	 * return new ResponseEntity<String>(exception.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	/*
	 * @ExceptionHandler(value = { NullPointerException.class,
	 * ArithmeticException.class }) public ResponseEntity<String>
	 * handleException(Exception exception) {
	 * 
	 * return new ResponseEntity<String>(exception.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<String> npeException(NullPointerException npe) {

		return new ResponseEntity<String>(npe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { ArithmeticException.class })
	public ResponseEntity<String> aeException(ArithmeticException ae) {

		return new ResponseEntity<String>(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
