package com.learning.corejava.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
	
	private CountDownLatch timer;
		
	public Runner(CountDownLatch timer, String name) {
		this.timer = timer;
		this.setName(name);
		this.start();
	}
	
	@Override
	public void run(){
		
		try {
			this.timer.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + " has started");
		
	}
}
