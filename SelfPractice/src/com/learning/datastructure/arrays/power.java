package com.learning.datastructure.arrays;

public class power {
	
	

		  /* Given base and integer exponent, compute value of base raised to the power of exponent.
		   * Can you implement a solution faster than O(exp)? 
		   */
		  public static double power(double base, int exp) {
		    if(base==0) return 0;
		    if(exp==0) return 1;
		    if(exp==1) return base;
		    int positiveExp =  (exp<0) ? exp*-1 : exp;
		    double result= (positiveExp%2==0)? power(base*base,positiveExp/2):base*power(base*base,(positiveExp-1)/2);
		    return exp<0 ? 1/result:result;
		  }
		  
		  public static void main(String[] args) {
			  
			  System.out.println(power(7,-2));
			
			  
			  
			  
		  }

}
