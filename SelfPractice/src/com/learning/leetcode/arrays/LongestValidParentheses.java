package com.learning.leetcode.arrays;

import java.util.Stack;

public class LongestValidParentheses {
	
public static int longestValidParentheses(String s) {
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int maxns=0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    maxns = Math.max(maxns,i-stack.peek());
                }
            } 
        }
        return maxns;
        
    }

	public static void main(String[] args) {
		
		System.out.println(longestValidParentheses("((()))()"));
		
	}

}
