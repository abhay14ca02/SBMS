package com.rajabhay.bean;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public int add2Nos(int x, int y) {

		return (x + y);
	}

	public int multiply2Nos(int x, int y) {

		return (x * y);
	}
}
