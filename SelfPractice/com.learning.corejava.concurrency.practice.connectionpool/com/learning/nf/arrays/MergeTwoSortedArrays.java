package com.learning.nf.arrays;


/**
 * Given two sorted arrays, merge them into one array which should also be sorted
 * 
 * @author test
 *
 */
public class MergeTwoSortedArrays {
	
	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		
		if(arr1 == null)
			return arr2;
		
		if(arr2 == null) {
			return arr1;
		}
		
		if(arr2 == null && arr1 == null) {
			return null;
		}
		
		int[] sortedArray = new int[arr1.length + arr2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<arr1.length && j<arr2.length) {
			
			if(arr1[i] < arr2[j]) {
				sortedArray[k] = arr1[i];
				i++;
			} else {
				sortedArray[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i<arr1.length) {
			sortedArray[k] = arr1[i];
			i++;
			k++;
		}
		
		while(j<arr2.length) {
			sortedArray[k] = arr2[j];
			j++;
			k++;
		}
		return sortedArray;
		
	}
	
	private static boolean doAllTests() {
		boolean result = true;
		int[] arr1 = {1,3,4,5}; 
		int[] arr2 = {2,6,7,8};
		
		result = result && mergeArrays(arr1,arr2).length == 8;
		result = result && mergeArrays(arr1,arr2)[6] == 7;
		
		return result;
	}
	
	public static void main(String[] aregs) {
		if(doAllTests()) {
			System.out.println("All Tests are passed.");
		} else {
			System.out.println("Tests are failed.");
		}
	}
	

}
