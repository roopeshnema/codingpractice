package com.learning.corejava.concurrency.executor;

public class ExecutorTest {
	public static void main(String[] args) {
		Task task = new Task();
		Thread t = new Thread(task);
		System.out.println("Calling Task.run by Runnable");
		t.start();
		
		System.out.println("Calling Task.run by Executor");
		
		RepeatedTask r = new RepeatedTask();
		r.execute(task, 3);
		
	}
}
