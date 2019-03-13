package com.learning.flipkart.interview.sample;

import com.learning.flipkart.interview.connection.Connection;
import com.learning.flipkart.interview.connection.ConnectionPool;
import com.learning.flipkart.interview.connection.ConnectionType;

public class ConnectionPoolSample {
	public static void main(String[] args) throws Exception {
		final int INITIAL_SIZE = 5;
		final int INCREMENT = 2;
		final int MAX_SIZE = 10;
		ConnectionPool pool = new ConnectionPool(INITIAL_SIZE, INCREMENT, MAX_SIZE, ConnectionType.MYSQL);
		
		//Compiler error
		//Connection connection = new MySQLConnection();
		for (int i = 0; i < MAX_SIZE * 2; i++) {
			Thread thread = new Thread(new Client(pool));
			thread.setName("Client" + (i + 1));
			thread.start();
		}
	}
}

class Client implements Runnable {
	ConnectionPool pool;
	
	Client(ConnectionPool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		Connection connection;
		try {
			connection = pool.getConnection();
			connection.execute();
			connection.close();
			//Runtime error - Can't free connection twice
			//connection.close();
			//Thread.sleep(1000);
			//Runtime error - can't use a freed connection
			//connection.execute();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}