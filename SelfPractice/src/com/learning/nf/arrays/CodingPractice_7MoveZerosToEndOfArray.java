package com.learning.nf.arrays;

public class CodingPractice_7MoveZerosToEndOfArray {
	
	
	public static int[] moveZerosToEndOfArray(int[] arr) {
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] != 0) {
				arr[index++] = arr[i];
			}
			
		}
		
		for(int i=index; i<arr.length; i++) {
			arr[index++] = 0;
		}
		
		return arr;
		
	}
	
	public static int[] moveZerosToStartOfArray(int[] arr) {
		int index = arr.length-1;
		for(int i=arr.length-1; i>=0; i--) {
			
			if(arr[i] != 0) {
				arr[index--] = arr[i];
			}
			
		}
		
		for(int i=index; i>=0; i--) {
			arr[index--] = 0;
		}
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		
		int[] intArr = {0,1,0,3,12};
		
		intArr = moveZerosToEndOfArray(intArr);
		
		for(int i=0; i<intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
		
		System.out.println("");
		
		intArr = moveZerosToStartOfArray(intArr);
		
		for(int i=0; i<intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
	}

}
