package com.learning.corejava.misc;
import java.util.ArrayList;


public class Treasure {
	
	@SuppressWarnings("unchecked")
	public static String findNumberOnLatsStone(int noOfStone, int a, int b) {

		ArrayList<Integer> patterns = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		for(int i=0;i<noOfStone-1; i++) {
			for(Integer t : temp) {
				if(!patterns.contains(t + a))
					patterns.add(t + a);
				if(!patterns.contains(t + b))
					patterns.add(t + b);
			}
			temp = (ArrayList<Integer>) patterns.clone();
			patterns.clear();
		}
		
		return temp.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(findNumberOnLatsStone(5,10,100));
	}

}
