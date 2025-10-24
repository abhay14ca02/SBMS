package com.rajabhay.beans;

import java.lang.reflect.Field;

public class MyApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// load java class into jvm
		Class<?> forName = Class.forName("com.rajabhay.beans.User");
		// load class variable
		Field field = forName.getDeclaredField("age");
		// give access for variable
		field.setAccessible(true);
		// getting obj of loaded class
		Object newInstance = forName.newInstance();
		// type casting
		User user = (User) newInstance;
		user.getAge();
		// set value to private variable
		field.set(newInstance, 30);
		user.getAge();
	}
}
