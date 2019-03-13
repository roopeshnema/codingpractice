package com.learning.nf.arrays;

public abstract class ReArrangePositiveAndNegative {

	public static void reArrange(int[] arr) {
		int n = arr.length;

		int j=0;
		for(int i=0; i<n; i++) {
			if(arr[i] < 0) {
				if( i != j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					j++;
				}
			}
		}
	}
	
	// A utility function to print an array 
    static void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        int arr[] = {10,-1,20,4,5,-9,-6}; 
        int n = arr.length; 
  
        reArrange(arr); 
        printArray(arr, n); 
    }
}
