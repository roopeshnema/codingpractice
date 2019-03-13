package com.learning.nf.arrays;

public class FirstNonRepeatingInteger {
	
	private static int firstNonRepeatingInteger(int[] arr) {
		
		int[] bitmap = new int[256];
		int firstNonRepeating = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			bitmap[arr[i]] = bitmap[arr[i]] + 1;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(bitmap[arr[i]] == 1) {
				firstNonRepeating = arr[i];
				break;
			}
		}
		
		return firstNonRepeating;
		
	}
	
	public static void main(String[] args) {
		int[] inputArr = {9,2,3,2,6,6};
		
		System.out.print(firstNonRepeatingInteger(inputArr));
	}

}
