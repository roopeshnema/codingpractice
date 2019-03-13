package com.learning.nf.concurrency.callbackexecutor;

public class CallBackDemonstration {
	
	public static void main( String args[] ) throws InterruptedException {
		
		final DeferredCallbackExecutor instance = DeferredCallbackExecutor.getInstance();
		instance.start();
        
        Thread lateThread = new Thread(new Runnable() {
            public void run() {
                CallBack cb = new CallBack(8, "Hello this is late thread");
                instance.registerCallback(cb);
            }
        });
        lateThread.start();

        Thread.sleep(3000);
        
        Thread earlyThread = new Thread(new Runnable() {
            public void run() {
                CallBack cb = new CallBack(1, "Hello this is early thread");
                instance.registerCallback(cb);
            }
        });
        earlyThread.start();

        Thread.sleep(3000);
    }

}
