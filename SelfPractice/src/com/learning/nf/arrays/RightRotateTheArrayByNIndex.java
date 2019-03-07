package com.learning.nf.arrays;

public class RightRotateTheArrayByNIndex {
	
	private static int[] rotateArray(int[] intArr, int rotationPoint) {
		
		//Step 1
		
		int i = intArr.length - rotationPoint;
		
		// Step 2
		intArr = rotateSubArray(intArr,0,i-1);
		
		intArr = rotateSubArray(intArr,i,intArr.length-1);
		
		// Step 3
		
		intArr = rotateSubArray(intArr,0,intArr.length-1);
		
		return intArr;
		
	}

	private static int[] rotateSubArray(int[] arr, int start, int end) {
		
		while(start <= end) {
			
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp; 
			start++;
			end--;
			
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5,6,7};
		intArr = rotateArray(intArr,2);
		
		for(int i=0; i<intArr.length; i++) {
			System.out.print(intArr[i]);
		}
		
	}

}
