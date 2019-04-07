package com.learning.leetcode.arrays;

public class EditDistance {
	
	private static int minDistance(String str1, String str2) {
		
		char[] strArray1 = str1.toCharArray();
		char[] strArray2 = str2.toCharArray();
		int[][] editDistanceArr = new int[str1.length() + 1][str2.length() + 1];
		
		
		for(int i=0; i<=strArray1.length ; i++) {
			for(int j=0; j<=strArray2.length; j++) {
				if(i==0 && j==0) {
				editDistanceArr[0][0] = 0;
				} else if( i== 0) {
					editDistanceArr[0][j] = editDistanceArr[0][j-1] + 1;
				} else if( j==0) {
					editDistanceArr[i][0] = editDistanceArr[i-1][0] + 1;
				} // If last characters are same, ignore last char 
                // and recur for remaining string 
                else if (strArray1[i-1] == strArray2[j-1]) {
                	editDistanceArr[i][j] = editDistanceArr[i-1][j-1]; 
                }
       
                // If the last character is different, consider all 
                // possibilities and find the minimum 
                else {
                	editDistanceArr[i][j] = 1 + min(editDistanceArr[i][j-1],  // Insert 
                			editDistanceArr[i-1][j],  // Remove 
                			editDistanceArr[i-1][j-1]); // Replace 
                }
				
			}
		}
		
		return editDistanceArr[str1.length()][str2.length()];
		
	}
	
	static int min(int x,int y,int z) 
    { 
        if (x <= y && x <= z) return x; 
        if (y <= x && y <= z) return y; 
        else return z; 
    } 
	
	public static void main(String args[]) 
    { 
        String str1 = "sunday"; 
        String str2 = "saturday"; 
        System.out.println( minDistance( str1 , str2)); 
    } 

}
