package com.learning.corejava.java8features;


/**
 * Runnable interface is a FunctionInterface so we can use lambda expression
 * without writing MyRunnable class.
 * 
 * 
 * @author test
 *
 */
/*
class MyRunnable implements Runnable{

	@Override
	public void run() {

		for(int i=0; i<100; i++) {
			System.out.println("Child Thread");
		}

	}
}
*/

class LambdaWithMultiThreading {
	public static void main(String[] args) {
		
		Runnable r = ()-> {
			for(int i=0; i<100; i++) {
				System.out.println("Child Thread");
			}
		};
		
		Thread t = new Thread(r);
		t.start();	
		
		for(int i=0; i<100; i++) {
			System.out.println("Parent Thread");
		}

	}	
}


