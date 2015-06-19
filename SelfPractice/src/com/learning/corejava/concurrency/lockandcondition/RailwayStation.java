package com.learning.corejava.concurrency.lockandcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RailwayStation {
	Lock station = new ReentrantLock();
	Condition joeArrival = station.newCondition();
	
	
	class Train extends Thread {
		
		Train(String name){
			this.setName(name);
		}
		
		public void run(){
			station.lock();
			try{
				if(this.getName().startsWith("22650")) {
					joeArrival.signalAll();
				}
			}finally {
				station.unlock();
			}
		}
	
	}
	
	class WaitingForJoe extends Thread {
		public void run() {
			try{
				joeArrival.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				station.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
//		//new WaitingForJoe().start();
//		new Train("Train 1").start();
//		new Train("Train 1").start();
	}
}
