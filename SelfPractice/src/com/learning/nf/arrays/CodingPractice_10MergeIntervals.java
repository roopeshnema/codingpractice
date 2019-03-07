package com.learning.nf.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CodingPractice_10MergeIntervals {
	
	private List<Interval> mergeIntervals(List<Interval> intervals) {
		
		if(intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		int preStart = intervals.get(0).getStart();
		int preEnd = intervals.get(0).getEnd();
		
		List<Interval> result = new ArrayList<Interval>();
		
		for(int i=1; i<intervals.size(); i++) {
			Interval current = intervals.get(i);
			
			// No Overlap
			if(current.getStart() > preEnd) {
				result.add(new Interval(preStart, preEnd));
				preStart = current.getStart();
				preEnd = current.getEnd();
			} else {
				preEnd = Math.max(current.getEnd(),preEnd);
			}
			
		}
		
		result.add(new Interval(preStart, preEnd));
		
		return result;
		
	}
	
	private class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			
			return o1.getStart() - o2.getStart();	
		}
		
	}
	
	public static void main(String[] args) {
		
		CodingPractice_10MergeIntervals driver = new CodingPractice_10MergeIntervals();
		List<Interval> input = new ArrayList<Interval>();
		
		input.add(new Interval(1,3));
		input.add(new Interval(2,6));
		input.add(new Interval(8,10));
		input.add(new Interval(15,18));
		
		List<Interval> result = driver.mergeIntervals(input);
		
		for(int i=0; i<result.size(); i++) {
			System.out.print("(" + result.get(i).getStart() + "," + result.get(i).getEnd() + ") ");
		}
		
	}
	

}
