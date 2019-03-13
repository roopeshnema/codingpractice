package com.learning.nf.concurrency.readwritelock;

public class ReadWriteLock {
	
	 boolean isWriteLocked = false;
	 int readers = 0;
	 
	 public synchronized void acquireReadLock() throws InterruptedException {
		 
		 while(isWriteLocked) {
			 wait();
		 }
		 
	 }
	 
	 public synchronized void releaseReadLock() {
		 readers--;
		 notifyAll();
	 }
	 
	 public synchronized void acquireWriteLock() throws InterruptedException {
		 
		 while(isWriteLocked || readers !=0 ) {
			 wait();
		 }
		 
		 isWriteLocked = true;
		 
	 }
	 
	 public synchronized void releaseWriteLock() {
		 
		 isWriteLocked = false;
		 notifyAll();
	 }


}
