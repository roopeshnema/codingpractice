package com.learning.corejava.java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Comparator interface is a FunctionInterface so we can use lambda expression
 * without writing MyComparator class.
 * 
 * 
 * @author test
 *
 */

/*
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return (o1>o2)?-1:(o1 < o2)?1:0;
		
	}
	
}
*/

public class LambdaWithCollections {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(25);
		arrayList.add(27);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(10);
		
		System.out.println(arrayList);
		
		Comparator<Integer> c = (o1,o2)->(o1>o2)?-1:(o1 < o2)?1:0;
		
		Collections.sort(arrayList,c); 
		System.out.println(arrayList);
	}
	
	
	

}
