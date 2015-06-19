package com.learning.corejava.concurrency.executor;

import java.util.concurrent.Executor;

public class RepeatedTask implements Executor{

	@Override
	public void execute(Runnable runnable) {		
		new Thread(runnable).start();
	}
	
	public void execute(Runnable runnable, int noOfTimes) {
		for(int i=0; i<noOfTimes; i++){
			execute(runnable);
		}
	}

}
