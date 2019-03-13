package com.learning.flipkart.interview.connection;

public class ProxyConnection extends Connection {
	private Connection connection;
	
	protected ProxyConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void execute() throws Exception {
		if (connection == null) 
			throw new Exception("Connection is not found or already closed");

		connection.execute();
	}

	public void close() throws Exception {
		connection.close();
		connection = null;
	}
}
