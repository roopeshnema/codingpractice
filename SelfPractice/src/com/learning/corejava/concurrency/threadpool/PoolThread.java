package com.learning.corejava.concurrency.threadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread{
	
	private BlockingQueue taskQueue = null;
    private boolean isStopped = false;
    
    public PoolThread(BlockingQueue taskQueue) {
    	this.taskQueue = taskQueue;
    }
    
    public void run(){
    	
    	 while(!isStopped){
             try{
                 Runnable runnable = (Runnable) taskQueue.remove();
                 runnable.run();
             } catch(Exception e){
                 //log or otherwise report exception,
                 //but keep pool thread alive.
             }
         }
    	
    }
    
    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

}
