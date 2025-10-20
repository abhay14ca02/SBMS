package com.rajabhay.beans;

public class DiselEngine implements IEngine {

	public DiselEngine() {
		System.out.println("DiselEngine Constructor...");
	}

	@Override
	public int start() {
		System.out.println("DiselEngine started...");
		return 1;
	}

}
