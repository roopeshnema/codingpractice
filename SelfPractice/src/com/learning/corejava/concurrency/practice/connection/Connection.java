package com.learning.corejava.concurrency.practice.connection;



public abstract class Connection {
	private boolean free = true;
	public boolean isFree() {
		return free;
	}
	public void setUsed(boolean free) {
		this.free = free;
	}
	public ConnectionPool getPool() {
		return pool;
	}
	public void setPool(ConnectionPool pool) {
		this.pool = pool;
	}
	private ConnectionPool pool;
	public abstract void execute() throws Exception;
	
}
