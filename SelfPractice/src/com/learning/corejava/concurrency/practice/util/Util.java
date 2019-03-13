package com.learning.corejava.concurrency.practice.util;

public class Util {
	public static void log(String message, Class<?> c) {
		System.out.println(c.getSimpleName() + ": " + message);
	}
}
