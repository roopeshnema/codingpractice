package com.learning.nf.concurrency.implementsemaphore;

public class SemaphoreDemostration {
	
	public static void main( String args[] ) throws InterruptedException {
        
	      final CountingSemaphore cs = new CountingSemaphore(1);

	        Thread t1 = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                try {
	                    for (int i = 0; i < 5; i++) {
	                        cs.acquire();
	                        System.out.println("Ping " + i);
	                    }
	                } catch (InterruptedException ie) {

	                }
	            }
	        });
	
	        Thread t2 = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                for (int i = 0; i < 5; i++) {
	                    try {
	                        cs.release();
	                        System.out.println("Pong " + i);
	                    } catch (InterruptedException ie) {

	                    }
	                }
	            }
	        });
	        
	        t2.start();
	        t1.start();
	        t1.join();
	        t2.join();
	}
}
