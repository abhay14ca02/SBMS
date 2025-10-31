package com.rajabhay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/product")
	public String getSamsungProduct(Model model) {
		model.addAttribute("message", "Samsung M35 price is 16k...");
		return "index";
	}
}
