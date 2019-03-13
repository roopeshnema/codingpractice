package com.learning.nf.concurrency.blockingqueue;

public class BlockingQueueDemonstration {
	
	public static void main(String[] args) throws InterruptedException {
		
		final BlockingQueue<Integer> blockingQueue = new BlockingQueue<Integer>(5);

		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
                    for (int i = 0; i < 50; i++) {
                    	blockingQueue.enqueue(new Integer(i));
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {

                }
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 2 dequeued: " + blockingQueue.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 3 dequeued: " + blockingQueue.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
				
			}
		});
		
		t1.start();
        Thread.sleep(4000);
        t2.start();

        t2.join();

        t3.start();
        t1.join();
        t3.join();
		
	}

}
