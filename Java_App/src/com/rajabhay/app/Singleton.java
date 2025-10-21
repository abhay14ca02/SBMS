package com.rajabhay.app;

public class Singleton {

	private static Singleton instance = null;

	// We can do eager loading also by declaring
	// private static Singleton instance = new Singleton();
	// and then return object in getInstance() as we need not check null

	// Step 1 : Make Constructor private
	private Singleton() {
		System.out.println("Singleton :: Constructor");
	}

	// Step 2 : Make static method to return same object when Object is created
	// It's lazy loading
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {

		Singleton obj1 = getInstance();
		Singleton obj2 = getInstance();
		System.out.println(obj1.hashCode());
	}
}
