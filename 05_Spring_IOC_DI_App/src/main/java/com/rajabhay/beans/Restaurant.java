package com.rajabhay.beans;

public class Restaurant {

	private IPayment iPayment;

	public Restaurant() {
		System.out.println("Restaurant:: 0 Param Constructor");
	}

	// CI
	public Restaurant(IPayment payment) {
		System.out.println("Restaurant :: Param Constructor");
		this.iPayment = payment;
	}

	// SI
	public void setIPayment(IPayment payment) {
		System.out.println("setIPayment() called...");
		this.iPayment = payment;
	}

	public void bill() {

		String message = iPayment.pay();
		System.out.println("Sucess ::" + " " + message);
	}
}
