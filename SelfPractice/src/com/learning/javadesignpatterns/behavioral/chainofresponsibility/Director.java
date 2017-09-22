package com.learning.javadesignpatterns.behavioral.chainofresponsibility;

public class Director extends Handler{

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE) {
			System.out.println("Director can approve ");
		} else {
			successor.handleRequest(request);
		}
		
	}

}
