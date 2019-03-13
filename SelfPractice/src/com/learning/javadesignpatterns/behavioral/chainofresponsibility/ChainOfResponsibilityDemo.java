package com.learning.javadesignpatterns.behavioral.chainofresponsibility;

public class ChainOfResponsibilityDemo {
	
	public static void main(String[] args) {
		Director A = new Director();
		VP B = new VP();
		CEO C = new CEO();
		
		A.setSuccessor(B);
		B.setSuccessor(C);
		
		Request request = new Request(RequestType.PURCHASE, 1800);
		A.handleRequest(request);
		
	}

}
