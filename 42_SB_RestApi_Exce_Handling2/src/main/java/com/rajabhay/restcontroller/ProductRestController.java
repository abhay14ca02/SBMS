package com.rajabhay.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.eception.ProductNotFoundException;

@RestController
public class ProductRestController {

	@GetMapping("/product")
	public ResponseEntity<String> getProductInfo(@RequestParam String name) {

		String msg = null;

		if ("Samsung".equals(name)) {
			msg = "New Samsung mobiles sale going on...";
			return new ResponseEntity<>(msg, HttpStatus.OK);

		} else if ("Apple".equals(name)) {
			msg = "New Apple mobiles sale going on...";
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} else {

			throw new ProductNotFoundException("Product not found...");
		}
	}
}
