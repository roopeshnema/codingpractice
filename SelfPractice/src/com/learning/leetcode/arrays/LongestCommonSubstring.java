package com.learning.leetcode.arrays;

public class LongestCommonSubstring {
	
	public String longestCommonSubstring(char str1[], char str2[]){
		int T[][] = new int[str1.length+1][str2.length+1];

		int max = 0, resultI=0;
		for(int i=1; i <= str1.length; i++){
			for(int j=1; j <= str2.length; j++){
				if(str1[i-1] == str2[j-1]){
					T[i][j] = T[i-1][j-1] +1;
					if(max < T[i][j]){
						max = T[i][j];
						resultI = i;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while(resultI >= 0 && max > 0) {
			sb.append(str1[resultI-1]);
			resultI--;
			max--;
		}
		return sb.toString();
	}

	public static void main(String args[]){
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		char str1[] = "babad".toCharArray();
		char str2[] = "bab".toCharArray();
		System.out.println(lcs.longestCommonSubstring(str1, str2));

	}

}
