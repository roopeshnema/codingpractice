package com.learning.corejava.concurrency.executor;

public class Task implements Runnable{
	public void run() {
		System.out.println("Calling Task.run()");
	}
}