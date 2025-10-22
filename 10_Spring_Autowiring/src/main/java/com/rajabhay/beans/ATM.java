package com.rajabhay.beans;

public class ATM {

	private IPrinter printer;

	public ATM() {
		System.out.println("ATM 0 - Param Constructor...");
	}

	// SI
	public void setPrinter(IPrinter printer) {
		this.printer = printer;
	}

	// CI
	public ATM(IPrinter printer) {
		System.out.println("ATM 1 - Param Constructor...");
		this.printer = printer;
	}

	public void withdraw() {
		System.out.println("Withdraw successful..");
		printer.print();
	}
}
