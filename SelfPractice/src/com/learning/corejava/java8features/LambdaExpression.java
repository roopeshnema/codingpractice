package com.learning.corejava.java8features;

public class LambdaExpression {
	
	
	public static void main(String[] args) {
		
		LambdaExpressionInterface lambdaExpressionFI = (a,b)->System.out.println("Sum is :" + (a+b));
		lambdaExpressionFI.add(10, 20);
		lambdaExpressionFI.add(100, 200);
	}
	
	
}