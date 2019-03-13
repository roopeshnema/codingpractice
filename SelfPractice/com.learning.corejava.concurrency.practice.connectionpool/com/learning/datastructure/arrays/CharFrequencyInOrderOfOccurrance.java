package com.learning.datastructure.arrays;

/**
 * Print characters and their frequencies in order of occurrence.
 * 
 * Given a string str containing only lower case characters. The problem is to
 * print the characters along with their frequency in order of their occurrence
 * and in the given format explained in the examples below.
 *
 * Examples:
 * 
 * Input : str = "elephant" Output : e2 l1 p1 h1 a1 n1 t1
 * 
 * @author Roopesh
 *
 */
public class CharFrequencyInOrderOfOccurrance {
	
	
	private static void charFrequencyInOrderOfOccurrance(String str) {
		
		char[] charArray = str.toCharArray();
		
		int[] intArray = new int[256];
		
		int charArrayLength = charArray.length;
		
		// Increment the counter
		for(int i=0; i<charArrayLength; i++) {
			int asciiValue = charArray[i];
			intArray[asciiValue] = intArray[asciiValue] + 1;
		}
		
		// Remove the duplicate printing.
		boolean[] flagArray = new boolean[256];
		for(int i=0; i<charArrayLength; i++) {
			int asciiValue = charArray[i];
			if(!flagArray[asciiValue]) {
				System.out.print("" + charArray[i] + intArray[asciiValue] + "  ");
				flagArray[asciiValue] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		charFrequencyInOrderOfOccurrance("geeksforgeeks");
	}

}
