package com.learning.nf.arrays;

public class Interval {
	
	private int start;
	private int end;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	Interval(int start, int end) {
		this.end = end;
		this.start = start;
	}
}
