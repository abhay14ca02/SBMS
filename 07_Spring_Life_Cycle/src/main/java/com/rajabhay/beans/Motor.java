package com.rajabhay.beans;

public class Motor {

	public Motor() {
		System.out.println("Motor Constructor...");
	}

	// init method
	public void start() {
		System.out.println("Motor started...");
	}

	public void doWork() {
		System.out.println("Motor is working...");
	}

	// destroy method
	public void stop() {
		System.out.println("Motor is stopped...");
	}
}
