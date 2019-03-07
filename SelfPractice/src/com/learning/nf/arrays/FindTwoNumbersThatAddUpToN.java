package com.learning.nf.arrays;

import java.util.HashMap;

public class FindTwoNumbersThatAddUpToN {
	
	
	// Solution 1 
	private static int[] findSum(int[] arr, int value) {
		
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i=0; i<arr.length; i++) {
			int mapkey = value - arr[i];
			int mapValue = 1;
			if(hashMap.containsKey(mapkey)) {
				mapValue  = hashMap.get(mapkey) + 1 ;
			}
		    hashMap.put(mapkey, mapValue);
			
		}
		
		for(int i=0; i<arr.length; i++) {
			
			if (hashMap.containsKey(arr[i])) {
				if(arr[i] == value - arr[i] && hashMap.get(arr[i]) != 2) {
					continue;
				}
				result[0] = arr[i];
				result[1] = value - arr[i];
				return result;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		int[] sampleArr = {6,7,8,6};
		int[] arr = findSum(sampleArr,12);
		System.out.println("" + arr[0] + " " + arr[1] );
		
	}

}
