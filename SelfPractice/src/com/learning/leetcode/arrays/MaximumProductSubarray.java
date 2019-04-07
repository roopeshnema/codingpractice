package com.learning.leetcode.arrays;

public class MaximumProductSubarray {
	
public static int maxProduct(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int prevMaxProduct = nums[0];
        int prevMinProduct = nums[0];
        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0];
        int ans = 0;
        
        for(int i=1; i< nums.length; i++) {
            currentMaxProduct = max(prevMaxProduct*nums[i],prevMinProduct * nums[i],nums[i]);
            currentMinProduct = min(prevMaxProduct*nums[i],prevMinProduct * nums[i],nums[i]);
            ans = Math.max(ans,currentMaxProduct);
            
            if(currentMaxProduct > prevMaxProduct) {
            	prevMaxProduct = currentMaxProduct;
            }
            if(currentMinProduct < prevMinProduct) {
            prevMinProduct = currentMinProduct;
            }
            
        }
        
        return ans;
        
    }
    
    private static int max(int x, int y, int z) {
        if(x >= y && x >= z) {
            return x;
        } else if (y >= x && y >= z) {
            return y;
        }
        return z;
    }
    
    private static int min(int x, int y, int z) {
        if(x<=y && x<=z) {
            return x;
        } else if(y<=x && y<=z) {
            return y;
        }
        return z;
    }
    
    public static void main(String[] args) {
    	
    	int[] input = {2,-1,1,1};
    	System.out.println(maxProduct(input));
    	
    }

}
