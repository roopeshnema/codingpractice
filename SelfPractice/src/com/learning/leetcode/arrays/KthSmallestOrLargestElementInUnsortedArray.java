package com.learning.leetcode.arrays;

import java.util.PriorityQueue;

public class KthSmallestOrLargestElementInUnsortedArray {


	private static int kthSmallestOrLargestElementInUnsortedArray(int[] arr, int k) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		for(int i=0; i<arr.length; i++) {

			priorityQueue.add(arr[i]);
			if(i >= k) {
				priorityQueue.remove();
			}

		}
		return priorityQueue.remove();
	}

	public static void main(String[] args) {
		
		int[] intArr = {7, 10, 4, 3, 20, 15};

		System.out.println(kthSmallestOrLargestElementInUnsortedArray(intArr,4));
	}

}
