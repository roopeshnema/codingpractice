package com.learning.nf.arrays;

public class FindMinimumValueInArray {
	
	private static int findMinimumValueInArray(int[] arr) {
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i]) {
				min  = arr[i];
			}
		}
		return min;
		
	}
	
	public static void main(String[] args) {
		int[] intArr = {9,2,3,6};
		
		System.out.print(findMinimumValueInArray(intArr));
	}

}
