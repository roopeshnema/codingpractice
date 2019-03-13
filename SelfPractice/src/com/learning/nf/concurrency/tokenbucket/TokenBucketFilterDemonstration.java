package com.learning.nf.concurrency.tokenbucket;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketFilterDemonstration {
	
	public static void main( String args[] ) throws InterruptedException {
        runTestMaxTokenIs1();
    }
	
	public static void runTestMaxTokenIs1() throws InterruptedException {

        Set<Thread> allThreads = new HashSet<Thread>();
        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }
    }

}
