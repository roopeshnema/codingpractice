package com.learning.flipkart.interview.util;

public class Util {
	public static void log(String message, Class<?> c) {
		System.out.println(c.getSimpleName() + ": " + message);
	}
}
