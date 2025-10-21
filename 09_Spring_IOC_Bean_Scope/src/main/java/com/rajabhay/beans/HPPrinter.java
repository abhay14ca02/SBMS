package com.rajabhay.beans;

public class HPPrinter implements IPrinter {

	public HPPrinter() {
		System.out.println("HPPrinter :: Constructor");
	}

	@Override
	public void print() {
		System.out.println("HPPrinter - printing...");

	}

}
