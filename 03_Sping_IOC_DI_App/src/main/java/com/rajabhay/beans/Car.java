package com.rajabhay.beans;

public class Car {

	private Engine engine;

	public Car() {
		System.out.println("Car :: Constructor");
	}

	//CI
	public Car(Engine eng) {
		System.out.println("Car :: param Constructor");
		this.engine = eng;
	}

	// SI
	public void setEngine(Engine eng) {
		System.out.println("setEngine() -- called..");
		this.engine = eng;
	}

	public void drive() {
		int status = engine.startEngine();
		if (status == 1) {
			System.out.println("Journey started...");
		} else {
			System.out.println("Engine failure...");
		}
	}
}
