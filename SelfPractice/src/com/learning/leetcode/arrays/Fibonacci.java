package com.learning.leetcode.arrays;

public class Fibonacci {

	public static void main(String[] args) {
		if(doAllTests()) {
			System.out.println("All Tests Passed");
			return;
		} 

		System.out.print("THere are Test Case Failures");
	}

	private static boolean doAllTests() {
		boolean result = true;

		result = result && fibonacci(3) == 3 && fibonacci(8) == 34 && fibonacci(2) == 2 && fibonacci(6) == 13; 
		return result;
	}

	private static int fibonacci(int n) {

		int[] stairs = new int[n+1];

		stairs[0] = 0;
		stairs[1] = 1;
		stairs[2] = 2;

		for(int i=3; i<=n ; i++ ) {

			stairs[i] = stairs[i-1] + stairs[i-2];

		}

		return stairs[n];
	}

}

//  0 1  2  3  4  5  6  7   8 
//  0 1  1  2  3  5  8  13  21
