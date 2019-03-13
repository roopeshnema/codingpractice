package com.learning.nf.arrays;

public class FindSecondMaximumValue {

	public static int findSecondMaximum(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if(arr[i] > secondMax) {
				secondMax = arr[i];
			}
		}
		
		return secondMax;
	}
	
	public static void main(String[] args) {
		int[] intArr = {9,2,3,6};
		System.out.println(findSecondMaximum(intArr));
	}

}
