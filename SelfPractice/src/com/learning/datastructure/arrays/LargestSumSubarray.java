package com.learning.datastructure.arrays;

public class LargestSumSubarray {
	
	public static void main(String[] args) {
		//int[] intArray = {-1,3,5,-10,5,7,2,-2,20,-15,2,6};
		//int[] intArray = { 1, 2, 3, 4 };
		int[] intArray = {1, 2, 3, 4 ,7,6};
		//exceedSubArray(intArray,6);
		System.out.println(subArrayExceedsSum(intArray,7));
	}
	
	// Solution 2
	
	private static int largestSumSubArrayKadaneAlgo(int[] arr, int target) {
		
		int sumEndingHere = 0;
		int sumSoFar = 0;
		int length = arr.length;
		sumSoFar = arr[0];
		
		for(int i=0; i<length; i++) {
			
			sumEndingHere  = sumEndingHere + arr[i];
			if(sumEndingHere > sumSoFar) {
				sumSoFar = sumEndingHere;
			}
			
			if(sumEndingHere < 0) {
				sumEndingHere = 0;
			}
		}
		
		return sumSoFar;
		
		
	}
	// Solution 1
	
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
	
	// Solution 1
	
		private static void exceedSubArray(int[] intArray, int target) {
			
			int maxSum = 0,maxStart = 0,maxEnd = 0, currentStart = 0, currentSum = 0, currentEnd = 0;
			
			while(currentEnd != intArray.length) {
				
				currentSum = currentSum + intArray[currentEnd];
				if(currentSum > target) {
					maxSum = currentSum;
					maxStart = currentStart;
					maxEnd = currentEnd;
				}
				
				if(currentSum < 0) {
					maxStart = currentEnd + 1;
					maxSum = 0;
				}
				currentEnd++;
				
			}
			System.out.println(maxSum);
			System.out.println(maxStart + " " + maxEnd);
		}
	//Solution 3
		
		public static int subArrayExceedsSum(int arr[], int target )
		  {
		  int i = 0, j = 0, length = Integer.MAX_VALUE, size = arr.length;
		  
		  if( target <= 0 )
		    return 0;
		  
		  if( size < 1 )
		    return -1;
		  
		  int currsum = arr[ 0 ];
		  while( true )
		  {
		    if( currsum >= target )
		    if( i == j )
		      return( 1 );
		    else
		    {
		      if( j - i + 1 < length )
		      length = j - i + 1;
		      currsum -= arr[ i ];
		      i++;
		    }
		    else
		    {
		    j++;
		    if( j == size )
		      break;
		    else
		      currsum += arr[ j ];
		    };
		  };

		  if( length == Integer.MAX_VALUE )
		    return -1;

		  return length;
		  }
	
}
