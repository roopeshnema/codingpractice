package com.learning.corejava.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class DukeThread extends Thread{

	private Exchanger<String> sillyTalk;

	DukeThread(Exchanger<String> sillyTalk) {
		this.sillyTalk = sillyTalk;
	}

	public void run(){

		String reply = null;
		try {
			reply = sillyTalk.exchange("Knock Knock !");
			System.out.println("Coffee Shop : " +  reply);

			reply = sillyTalk.exchange("Duke");
			System.out.println("Coffee Shop : " +  reply);


			reply = sillyTalk.exchange("The one who born in the coffee shop");
			

		} catch(InterruptedException e) {

		}



	}
}
