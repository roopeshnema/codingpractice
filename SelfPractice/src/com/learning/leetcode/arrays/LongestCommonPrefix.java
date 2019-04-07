package com.learning.leetcode.arrays;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if(strs == null || strs.length == 0) {
			return "";
		}

		int arrayLength = strs.length;

		// Find shortest string

		String minStr="";
		int minLength=0;

		minLength = strs[0].length();
		minStr = strs[0];

		for(int i=1; i<arrayLength; i++ ) {
			if(minLength > strs[i].length()) {
				minLength = strs[i].length();
				minStr = strs[i];
			}
		}

		for(int i=0; i<arrayLength; i++) {

			if(strs[i].equals(minStr)) {
				continue;
			}
			int j=0;
			String currentString = strs[i];

			while(j < minStr.length() && currentString.charAt(j) == minStr.charAt(j) ){
				j++;
			}

			if(j == 0) {
				return "";
			}

			minStr = currentString.substring(0,j);

		}

		return minStr;
	}

}
