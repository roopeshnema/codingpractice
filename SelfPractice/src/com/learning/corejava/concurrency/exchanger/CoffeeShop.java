package com.learning.corejava.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class CoffeeShop extends Thread{
	private Exchanger<String> sillyTalk;
	
	CoffeeShop(Exchanger<String> sillyTalk){
		this.sillyTalk = sillyTalk;
	}
	
	public void run() {
		
		String reply = null;
		try{
			reply = sillyTalk.exchange("who's there");
			System.out.println("Duke : " + reply);
			
			reply = sillyTalk.exchange("who Duke");
			System.out.println("Duke : " + reply);
			
			reply = sillyTalk.exchange("");
			System.out.println("Duke : " + reply);
		} catch(InterruptedException e) {
			
		}
	}
}
