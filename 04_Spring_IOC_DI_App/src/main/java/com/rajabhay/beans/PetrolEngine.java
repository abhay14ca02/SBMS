package com.rajabhay.beans;

public class PetrolEngine implements IEngine {

	public PetrolEngine() {
		System.out.println("PetrolEngine Constructor...");
	}

	@Override
	public int start() {
		System.out.println("PetrolEngine started...");
		return 1;
	}

}
