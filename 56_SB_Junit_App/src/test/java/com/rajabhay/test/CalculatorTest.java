package com.rajabhay.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rajabhay.bean.Calculator;

@SpringBootTest
public class CalculatorTest {

	@Test
	public void testAdd2Nos() {
		Calculator calculator = new Calculator();

		int actualResult = calculator.add2Nos(15, 20);
		int expectedResult = 35;

		// Assertions

		Assertions.assertEquals(expectedResult, actualResult);

	}
	
	@Test
	public void testMul2Nos() {
		Calculator calculator = new Calculator();

		int actualResult = calculator.multiply2Nos(15, 20);
		int expectedResult = 300;

		// Assertions

		Assertions.assertEquals(expectedResult, actualResult);

	}
}
