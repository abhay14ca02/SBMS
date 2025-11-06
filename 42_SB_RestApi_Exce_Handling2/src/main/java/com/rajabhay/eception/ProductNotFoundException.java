package com.rajabhay.eception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5047116585275018090L;

	public ProductNotFoundException() {

	}

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
