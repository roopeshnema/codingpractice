package com.learning.corejava.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player extends Thread{
	CyclicBarrier waitPoint;
	
	public Player(CyclicBarrier waitPoint, String name ) {
		this.waitPoint = waitPoint;
		this.setName(name);
		this.start();
	}
	
	public void run(){
		System.out.println("Player " + getName() + " is ready");
		try {
			this.waitPoint.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
