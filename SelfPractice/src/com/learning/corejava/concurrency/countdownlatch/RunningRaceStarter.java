package com.learning.corejava.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class RunningRaceStarter {
	
	public static void main(String[] args) {
		CountDownLatch timer = new CountDownLatch(5);		
		long countval = timer.getCount();
		
		new Runner(timer, "Ram");
		new Runner(timer, "Shayam");
		new Runner(timer, "Mohan");
		new Runner(timer, "Siva");
		new Runner(timer, "Raghav");
		
		while(countval > 0) {
			try {
				Thread.sleep(1000);
				countval = timer.getCount();
				System.out.println(countval);
				
				if(countval == 1) {
					System.out.println("start");
				}
				timer.countDown();				
				countval = timer.getCount();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	

}
