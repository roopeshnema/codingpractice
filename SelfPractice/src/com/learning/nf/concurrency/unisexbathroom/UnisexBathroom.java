package com.learning.nf.concurrency.unisexbathroom;

import java.util.concurrent.Semaphore;

public class UnisexBathroom {
	
	private InUseBy inUseBy;
	private int personsInBathRoom;
	
	Semaphore maxEmps = new Semaphore(3);
	
	void useBathroom(String name) throws InterruptedException {
        System.out.println("\n" + name + " using bathroom. Current employees in bathroom = " + personsInBathRoom + " " + System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println("\n" + name + " done using bathroom " + System.currentTimeMillis());
    }
	
	public void maleUseBathRoom(String name) throws InterruptedException {
		
		synchronized(this) {
			while(inUseBy == InUseBy.WOMEN ) {
				this.wait();
			}
			
			maxEmps.acquire();
			personsInBathRoom++;
			inUseBy = InUseBy.MEN;
		}

		useBathroom(InUseBy.MEN.toString());
		maxEmps.release();
		
		synchronized(this) {
			personsInBathRoom--;
			if (personsInBathRoom == 0) inUseBy = InUseBy.NONE;
            this.notifyAll();
		}
	}
	
	public void femaleUseBathRoom(String name) throws InterruptedException {
		
		synchronized(this) {
			while(inUseBy == InUseBy.MEN) {
				this.wait();
			}
			
			maxEmps.acquire();
			personsInBathRoom++;
			inUseBy = InUseBy.WOMEN;
		}
		
		useBathroom(InUseBy.WOMEN.toString());
		maxEmps.release();
		
		synchronized(this) {
			personsInBathRoom--;
			if (personsInBathRoom == 0) inUseBy = InUseBy.NONE;
            this.notifyAll();
		}
		
	}

}
