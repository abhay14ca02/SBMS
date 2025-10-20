package com.rajabhay.beans;

public class DebitCard implements IPayment {

	public DebitCard() {
		System.out.println("DebitCard Constructor...");
	}

	@Override
	public String pay() {
		return "Payment done through Debit Card...";
	}

}
