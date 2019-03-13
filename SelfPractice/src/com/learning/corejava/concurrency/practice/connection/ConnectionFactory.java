package com.learning.corejava.concurrency.practice.connection;



public class ConnectionFactory {
	public static Connection createConnection(ConnectionType type) throws Exception {
		switch(type) {
			case MYSQL:
				return new MySQLConnection();
			default:
				throw new Exception("Couldn't create connection of type: " + type.toString());
		}
	}
}
