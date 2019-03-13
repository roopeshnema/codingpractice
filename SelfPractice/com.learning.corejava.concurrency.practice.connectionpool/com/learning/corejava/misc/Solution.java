package com.learning.corejava.misc;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		ArrayList<Integer> linkedList = new ArrayList<Integer>();
		for(int i=0; i<testCases;i++){
			int noOfStones = sc.nextInt();
			int count1 = sc.nextInt();
			int count2 = sc.nextInt();
			
			for(int j=0; j<noOfStones; j++) {
				int counter = 0;
				int test1 = noOfStones-j-1;
				
				while(test1 > 0){
					counter+=count2;
					test1--;
				}
				
				int test2 = j;
				while(test2 > 0){
					counter+=count1;
					test2--;
				}
				if(!linkedList.contains((Integer)counter)) {
					linkedList.add((Integer)counter);
				}
			}
			for(int k=linkedList.size()-1; k>=0 ; k--){
				System.out.print(linkedList.get(k)+" ");
			}
			System.out.println();
			linkedList.clear();
		}
	}
	
}