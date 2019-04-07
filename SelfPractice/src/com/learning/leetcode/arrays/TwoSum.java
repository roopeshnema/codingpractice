package com.learning.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] result = {-1, -1};
		for(int i=0; i<nums.length; i++) {
			if(hm.containsKey(target-nums[i])) {
				int frequency = hm.get(target-nums[i]);
				hm.put(target-nums[i],frequency + 1);
			} else {
				hm.put(target-nums[i],1);
			}
		}

		for(int i=0; i<nums.length; i++) {
			

			if(hm.containsKey(nums[i]) && result[0] < 0) {
				if(nums[i] == target-nums[i] && hm.get(target-nums[i]) != 2) {
					continue;
				}
				result[0] = i;
			}
			if(result[0] >= 0 && nums[i] == target-nums[result[0]] )   {
				result[1] = i;
			}
		}

		return result;

	}
	
	// Solution 2 
	
	public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {

		int[] input = {2,7,11,15};
		int target = 9;
		int[] result = twoSum(input,target);

		System.out.print(result[0] + "  " + result[1]);
	}

}
