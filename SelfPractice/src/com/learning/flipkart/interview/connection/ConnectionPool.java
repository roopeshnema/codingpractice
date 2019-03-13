package com.learning.flipkart.interview.connection;

import java.util.ArrayList;
import java.util.List;

import com.learning.flipkart.interview.util.Util;


public class ConnectionPool {
	private final int INITIAL_SIZE;
	private final int INCREMENT;
	private final int MAX_SIZE;
	private final ConnectionType type;
	
	private List<Connection> connectionsList;
	
	public ConnectionPool(int initialSize, int increment, int maxSize, ConnectionType type) throws Exception {
		INITIAL_SIZE = initialSize;
		INCREMENT = increment;
		MAX_SIZE = maxSize;
		this.type = type;
		
		connectionsList = new ArrayList<>();
		if (connectionsList.size() < INITIAL_SIZE)
			increaseConnections(INITIAL_SIZE);
	}

	private void increaseConnections(int increment) throws Exception {
		Util.log("Incrementing the connections by " + increment, getClass());
		
		for (int i = 0; i < increment && connectionsList.size() < MAX_SIZE; i++) {
			Connection connection = ConnectionFactory.createConnection(type);
			connection.setConnectionPool(this);
			connectionsList.add(connection);
		}
	}
	
	private Connection getFreeConnection() {
		for (Connection connection: connectionsList) {
			if (connection.isFree()) {
				connection.setUsed();
				return connection;
			}
		}
		return null;
	}
	
	public Connection getConnection() throws Exception {
		Connection connection = null;
		synchronized (connectionsList) {
			while (connection == null) {
				connection = getFreeConnection();
				if (connection == null) {
					if (connectionsList.size() < MAX_SIZE) {
						increaseConnections(INCREMENT);
						connection = getFreeConnection();
					}
					else {
						try {
							Util.log(Thread.currentThread().getName() + " is waiting...", getClass());
							connectionsList.wait();
						} catch (InterruptedException e) {
						}
					}
				}
			}
		}
		return new ProxyConnection(connection);
	}
	
	protected void free(Connection connection) {
		synchronized(connectionsList) {
			connectionsList.notify();
		}
	}
}