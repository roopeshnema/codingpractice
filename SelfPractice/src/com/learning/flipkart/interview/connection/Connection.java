package com.learning.flipkart.interview.connection;

public abstract class Connection {
	private boolean free = true;
	private ConnectionPool pool;
	
	protected boolean isFree() {
		return free;
	}
	
	protected void setUsed() {
		free = false;
	}

	protected void setConnectionPool(ConnectionPool pool) {
		this.pool = pool;
	}
	
	public abstract void execute() throws Exception;
	
	public void close() throws Exception {
		if (pool == null)
			throw new Exception("ConnectionPool is not set on the connection");
		if (free)
			throw new Exception("Connection is already freed");
		
		free = true;
		pool.free(this);
	}
}