package com.rajabhay.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.bindings.Product;

@RestController
public class ProductRestController {

	@GetMapping(value = "/product/{pid}", produces = "application/json")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid) {
		Product product = new Product(pid, "Mobile", 36000.00);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<List<Product>> getProducts() {
		Product prod1 = new Product(101, "Mobile", 14567.00);
		Product prod2 = new Product(102, "Mouse", 1567.00);
		Product prod3 = new Product(103, "Laptop", 15567.00);
		List<Product> asList = Arrays.asList(prod1, prod2, prod3);
		return new ResponseEntity<List<Product>>(asList, HttpStatus.OK);
	}

	@PostMapping(value = "/product", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		System.out.println(product);
		// logic to save product
		String message = "Product saved in DB";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/product", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		System.out.println(product);
		// logic to update product
		String message = "Product updated...";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@PatchMapping(value = "/product", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updateProduct2(@RequestBody Product product) {
		System.out.println(product);
		// logic to partial update product
		String message = "Product updated partially...";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/product/{pid}", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> deleteroduct(Integer pid) {
		// logic to delete product
		String message = "Product deleted...";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
