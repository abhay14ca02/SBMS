package com.rajabhay.beans;

public class CreditCard implements IPayment {

	public CreditCard() {
		System.out.println("CreditCard Constructor...");
	}

	@Override
	public String pay() {

		return "Payment done through Creddit Card...";
	}

}
