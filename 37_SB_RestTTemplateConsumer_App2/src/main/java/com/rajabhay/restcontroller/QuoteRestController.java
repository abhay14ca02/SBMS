package com.rajabhay.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rajabhay.bindings.Quote;
import com.rajabhay.service.QuoteService;

@Controller
public class QuoteRestController {

	@Autowired
	private QuoteService quoteService;

	@GetMapping("/quotes")
	public String showQuotes(Model model) {
		List<Quote> quotes = quoteService.getQuotes();
		model.addAttribute("quotes", quotes);
		return "quotes";
	}

}
