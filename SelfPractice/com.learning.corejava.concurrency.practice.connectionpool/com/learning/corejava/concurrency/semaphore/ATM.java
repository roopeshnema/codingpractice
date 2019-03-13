package com.learning.corejava.concurrency.semaphore;

import java.util.concurrent.Semaphore;

class ATM {	
	
	public static void main(String[] args) {
		
		Semaphore machines = new Semaphore(2);		
		new Person(machines, "Ram");
		new Person(machines, "Mohan");
		new Person(machines, "Shyam");
		new Person(machines, "Siva");
		new Person(machines, "Manohar");	
		
	}

}
