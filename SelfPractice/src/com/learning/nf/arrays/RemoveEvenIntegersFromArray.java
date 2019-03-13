package com.learning.nf.arrays;

import java.util.ArrayList;

/**
 * Given an array of size n, remove all even integers from it.
 * 
 * Sample Input
 * 	arr = {1,2,4,5,10,6,
 * 	arr = {1,2,4,5,10,6,3}
 * Sample Output
 * 	arr = {1,5,3}
 * 
 * @author Roopesh
 *
 */
public class RemoveEvenIntegersFromArray {
	
	private static Integer[] removeEvenIntegers(Integer[] arr) {
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		if(arr == null) {
			return arrList.toArray(new Integer[arrList.size()]);
		}
		
		for(int i=0; i<arr.length ;i++) {
			if((arr[i] % 2) == 0) {
				arrList.add(arr[i]);
			}
		}
		
		return arrList.toArray(new Integer[arrList.size()]);
		
	}
	
	public static boolean doTestsPass() {
		
		boolean result = true;
		
		result = result && removeEvenIntegers(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}).length == 8;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		if(doTestsPass()) {
			System.out.println("All Test cases passed");
		} else {
			System.out.println("Test cases failed");
		}
	}
}
