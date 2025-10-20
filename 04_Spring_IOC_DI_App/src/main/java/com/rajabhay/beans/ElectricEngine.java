package com.rajabhay.beans;

public class ElectricEngine implements IEngine {

	public ElectricEngine() {

		System.out.println("ElectricEngine Constructor...");
	}

	@Override
	public int start() {
		System.out.println("ElectricEngine started...");
		return 1;
	}

}
