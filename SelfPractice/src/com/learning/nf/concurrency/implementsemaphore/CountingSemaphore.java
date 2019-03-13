package com.learning.nf.concurrency.implementsemaphore;

public class CountingSemaphore {
	
	private int usedPermits;
	private int maxPermits;
	
	public CountingSemaphore(int maxPermits) {
		this.maxPermits = maxPermits;
	}
	
	public synchronized void acquire() throws InterruptedException {

        while (usedPermits == maxPermits)
            wait();

        notify();
        usedPermits++;

    }
	
	public synchronized void release() throws InterruptedException {

        while (usedPermits == 0)
            wait();

        usedPermits--;
        notify();
    }
	
}
