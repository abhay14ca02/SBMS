package com.rajabhay.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.bindings.Product;

@RestController
public class ProductRestController {

	@PostMapping(value = "/product", consumes = { "application/json", "application/xml" }, produces = "text/plain")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		System.out.println(product);
		// logic to save product
		String msg = "Product saved...!";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/product/{pid}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid) {
		Product product = new Product(pid, "KeyBoard", 1234.00);
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@GetMapping(value = "/products", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Product>> getAllProducts() {
		Product prod1 = new Product(101, "Mouse", 446.00);
		Product prod2 = new Product(102, "RAM", 1446.00);
		Product produ3 = new Product(103, "Laptop", 11446.00);
		List<Product> list = Arrays.asList(prod1, prod2, produ3);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);

	}

	@PutMapping(value = "/product", consumes = { "application/json", "application/xml" }, produces = "text/plain")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		System.out.println(product);
		// logic to update product
		String msg = "Product updated...!";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping(value = "/product/{pid}", produces = "text/plain")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid) {
		// logic to delete
		String msg = "Product deleted...!";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
