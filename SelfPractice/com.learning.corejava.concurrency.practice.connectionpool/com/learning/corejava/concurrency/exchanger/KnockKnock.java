package com.learning.corejava.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class KnockKnock {
	
	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> sillyTalk = new Exchanger<String>();
		
		new DukeThread(sillyTalk).start();
		Thread.sleep(200);
		new CoffeeShop(sillyTalk).start();
	}
}
