package com.learning.corejava.java8features;

public interface DefaultMethodsForInterface {
	
	double calculculate(int a); 
	
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	
}
