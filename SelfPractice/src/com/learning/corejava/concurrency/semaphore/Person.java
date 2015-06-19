package com.learning.corejava.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class Person extends Thread{
	private Semaphore machine;
	
	public Person(Semaphore machine, String name){
		this.machine = machine;
		this.setName(name);		
		this.start();
	}
	
	@Override
	public void run(){
		System.out.println(this.getName() + " is waiting to use ATM machine");
		try {
			machine.acquire();
			System.out.println(this.getName() + " is using ATM machine");
			Thread.sleep(1000);
			machine.release();
			System.out.println(this.getName() + " is done.");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}

}
