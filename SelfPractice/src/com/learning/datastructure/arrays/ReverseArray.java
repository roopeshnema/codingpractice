package com.learning.datastructure.arrays;

/**
 * 
 * @author Roopesh
 *
 */
public class ReverseArray {
	
	private static int[] reverseArrayInPosition(int[] arr) {
		
		int i= 0;
		int j= arr.length-1;
		
		while(i<j) {
			swap(arr, i,j);
			i++;
			j--;
		}
		
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		reverseArrayInPosition(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i=0; i<=arr.length-1; i++) {
			System.out.print(arr[i]);
		}
		
	}

}
