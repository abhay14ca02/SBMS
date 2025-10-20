package com.rajabhay.beans;

public class UPI implements IPayment {

	public UPI() {
		System.out.println("UPI Constructor...");
	}

	@Override
	public String pay() {
		return "Payment done through UPI...";
	}

}
