package com.learning.datastructure.arrays;

/**
 ** 
 **  Given an array of non-negative integers representing the elevations
 **     from the vertical cross section of a range of hills, determine how
 **     many units of water could be captured between the hills. 
 **
 **     See the example array and elevation map below.
 **                                 ___
 **             ___                |   |        ___
 **            |   |        ___    |   |___    |   |
 **         ___|   |    ___|   |   |   |   |   |   |
 **     ___|___|___|___|___|___|___|___|___|___|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 *
 * @author Roopesh
 *
 */

public class RainWaterTrapping {

	
	/**
	 *  Here we are going to build 2 arrays leftMaxArr and rightMaxArr
	 *  Step 1 : To populate leftMaxArr, look for highest building in left side of current and then compare 
	 *  it with current, which ever is higher, populate it in the current index of leftMaxArr.
	 *   
	 *  Step 2 : To populate rightMaxArr, look for highest building in right side of current and then compare 
	 *  it with current, which ever is higher, populate it in the current index of rightMaxArr.
	 *  
	 *  Step 3 : Now we know left and right max for all the indexes, so iterate over the building array and just get 
	 *  the min of these 2 and subtract the building height, that will give the water trapped on that building,  
	 *  
	 */
	
	public static Integer computeRainWaterTrapping(Integer[] arr) {
		if(arr.length == 0) {
			return 0;
		}

		Integer[] leftMaxArr = new Integer[arr.length];
		Integer[] rightMaxArr = new Integer[arr.length];
		int leftLargest = 0;
		int rightLargest = 0;
		int totalWater = 0;
		for(int i=0; i<arr.length; i++) {
			if(leftLargest < arr[i]) {
				leftLargest = arr[i];
			} 
			leftMaxArr[i] = leftLargest;
		}

		for(int i=arr.length-1; i>=0; i--) {
			if(rightLargest < arr[i]) {
				rightLargest = arr[i];
			} 
			rightMaxArr[i] = rightLargest;
		}
		
		for(int i=0; i<leftMaxArr.length; i++) {
			System.out.print(leftMaxArr[i] + " ");
			
			
		}
		System.out.println("");
		for(int i=0; i<rightMaxArr.length; i++) {
			System.out.print(rightMaxArr[i] + " ");
			
			
		}

		for(int i=0; i<arr.length; i++) {
			totalWater = totalWater + ( Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i]);
		}

		System.out.println();
		System.out.println("Total water trapped is :" + totalWater);

		return null;
	}

	public static void main(String[] args) {
		Integer[] blockArr = {1,8,6,2,5,4,8,3,7,1};
		computeRainWaterTrapping(blockArr);
	}
}