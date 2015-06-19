package com.learning.datastructure.arrays;

public class LargestSumSubarray {
	
	public static void main(String[] args) {
		int[] intArray = {-1,3,5,-10,5,7,2,-2,20,-15,2,6};
		lagestSumSubArray(intArray);
	}

	private static void lagestSumSubArray(int[] intArray) {
		
		int maxSum = 0,maxStart = 0,maxEnd = 0, currentStart = 0, currentSum = 0, currentEnd = 0;
		
		while(currentEnd != intArray.length -1) {
			
			currentSum = currentSum + intArray[currentEnd];
			if(currentSum > maxSum) {
				maxSum = currentSum;
				maxStart = currentStart;
				maxEnd = currentEnd;
			}
			
			if(currentSum <= 0) {
				maxStart = currentEnd + 1;
				maxSum = 0;
			}
			currentEnd++;
			
		}
		System.out.println(maxSum);
		System.out.println(maxStart + " " + maxEnd);
	}	
}
