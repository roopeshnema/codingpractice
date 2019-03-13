package com.learning.nf.concurrency.callbackexecutor;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {
	
	private static DeferredCallbackExecutor instance;
	PriorityQueue<CallBack> q = new PriorityQueue<CallBack>(10, new Comparator<CallBack>() {
        public int compare(CallBack o1, CallBack o2) {
            return (int) (o1.getExecuteAt() - o2.getExecuteAt());
        }
    });
	
	ReentrantLock lock = new ReentrantLock();
    Condition newCallbackArrived = lock.newCondition();
    
    public void execute() throws InterruptedException {
       
        while(true) {
    	lock.lock();
        while (q.size() == 0) {
                newCallbackArrived.await();
         }
        
        long currentTime = System.currentTimeMillis();
        while (q.size() != 0 && currentTime >= q.peek().getExecuteAt()) {
            CallBack cb = q.poll();
            System.out.println("Executed at " + System.currentTimeMillis() / 1000 + " required at " + cb.getExecuteAt() / 1000 + ": message:" + cb.getMessage());
        }
        lock.unlock();   
        }
            
    }
    
    public void registerCallback(CallBack callBack) {
        lock.lock();
        q.add(callBack);
        newCallbackArrived.signal();
        lock.unlock();
    }
    
    public void start() throws InterruptedException {
       final DeferredCallbackExecutor deferredCallbackExecutor = getInstance();

        Thread service = new Thread(new Runnable() {
            public void run() {
                try {
                    deferredCallbackExecutor.execute();
                } catch (InterruptedException ie) {

                }
            }
        });
        service.start();
    }
    
    public static DeferredCallbackExecutor getInstance() {
    	if(instance == null) {
    		instance = new DeferredCallbackExecutor();
    	}
    	
    	return instance;
    }
}
    
  