package com.learning.nf.concurrency.tokenbucket;

public class TokenBucketFilter {
	
	private int MAX_TOKENS;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleTokens = 0;

    public TokenBucketFilter(int maxTokens) {
        MAX_TOKENS = maxTokens;
        possibleTokens = maxTokens;
    }
	 
    synchronized void getToken() throws InterruptedException {
    	
    	//System.out.println("MS is : " + (System.currentTimeMillis() - lastRequestTime)/ 1000);
    	//Thread.sleep(5000);
    	if((System.currentTimeMillis() - lastRequestTime) / 1000 >= 1) {
    		possibleTokens = possibleTokens +  1; 
    	}

        if (possibleTokens > MAX_TOKENS) {
            possibleTokens = MAX_TOKENS;
        }

        if (possibleTokens == 0) {
        	System.out.println("Blocked for " + Thread.currentThread().getName());
        	return;
            //Thread.sleep(1000);
        } else {
            possibleTokens--;
        }
        
        System.out.println("Possible Tokens are :" + possibleTokens);
        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
        
    }

}
