package com.learning.flipkart.interview.connection;

import com.learning.flipkart.interview.util.Util;

public class MySQLConnection extends Connection {
	protected MySQLConnection() {
	}
	
	@Override
	public void execute() throws Exception {
		Util.log(Thread.currentThread().getName() + " executing...", getClass());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}
