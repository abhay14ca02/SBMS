package com.rajabhay.eception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExeInfo {

	private String exCode;
	private String exMsg;
	private LocalDateTime exDate;
}
