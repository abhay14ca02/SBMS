package com.rajabhay.beans;

public class Car {

	public Car() {
		System.out.println("Car:: 0 - Param Constructor");
	}

	private IEngine iEngine;

	// CI
	public Car(IEngine engine) {
		System.out.println("Car:: Param Constructor");
		this.iEngine = engine;
	}

	// SI
	public void setIEngine(IEngine engine) {
		System.out.println("setIEngine() called...");
		this.iEngine = engine;
	}

	public void drive() {

		int status = iEngine.start();
		if (status == 1) {
			System.out.println("Car started...");
		} else {
			System.out.println("Engine failure...");
		}
	}
}
