package com.rajabhay.DTO;

import java.util.List;

import com.rajabhay.bindings.Quote;

import lombok.Data;

@Data
public class QuoteResponse {

	private List<Quote> quotes;
	private Integer total;
	private Integer skip;
	private Integer limit;
}
