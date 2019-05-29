package com.learning.nf.concurrency.tokenbucket;

public class TokenBucketFilter {
	
	private int MAX_TOKENS;
    private long lastRequestTime = System.currentTimeMillis();
    int remainingTokens = 0;

    public TokenBucketFilter(int maxTokens) {
        MAX_TOKENS = maxTokens;
        remainingTokens = maxTokens;
    }
	 
    synchronized void getToken() throws InterruptedException {
    	
    	if((System.currentTimeMillis() - lastRequestTime) / 1000 >= 1) {
    		System.out.println("Refilling the token by 1");
    		remainingTokens = remainingTokens +  1; 
    	}

        if (remainingTokens > MAX_TOKENS) {
        	remainingTokens = MAX_TOKENS;
        }

        if (remainingTokens == 0) {
        	System.out.println("Blocked for " + Thread.currentThread().getName());
        	Thread.sleep(300);
            return;
        } else {
        	remainingTokens--;
            
        }
        
        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
        System.out.println("Remaining Tokens are :" + remainingTokens);
    }

}
