package com.learning.nf.concurrency.callbackexecutor;

public class CallBack {
	
	private long executeAt;
	private String message;
	
    public long getExecuteAt() {
		return executeAt;
	}
	public void setExecuteAt(long executeAt) {
		this.executeAt = executeAt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public CallBack(long executeAfter, String message) {
        this.executeAt = System.currentTimeMillis() + executeAfter * 1000;
        this.message = message;
    }

}
