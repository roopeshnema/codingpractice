package com.learning.datastructure.arrays;

/* Problem Name is &&& Magic Potion &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
Instructions to candidate.
  1) Run this code in the REPL to observe its behaviour. The
   execution entry point is main.
  2) Consider adding some additional tests in doTestsPass().
  3) Implement minimalSteps() correctly.
  4) If time permits, some possible follow-ups.

Question: 
Hermione is preparing a cheat-sheet for her final exam in Potions class. 
To create a potion, one must combine ingredients in a specific order, any of which may be repeated. 

As an example, consider the following potion which uses 4 distinct ingredients 
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Hermione realizes she can save tremendous space on her cheat-sheet by introducing a 
special instruction, '*', which means "repeat from the beginning". 

Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,E

Your job is to write a function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode the potion on Hermione's Cheat Sheet.
*/

public class MagicPotion
{
  private Integer minimalSteps( String ingredients )
  {
  int n = ingredients.length();
  if (n == 0) {
    return 0;
  }

  Integer dp[] = new Integer[n];
  for (int i = 0; i < n; i++) {
    dp[i] = Integer.MAX_VALUE;
  }

  dp[0] = 1;
  for (int i = 1; i < n; i++) {
    dp[i] = Math.min(dp[i], dp[i - 1] + 1);

    // If the string can be replicated, we need to update at (2*i + 1)
    if (2*i + 1 < n 
      && ingredients.substring(0, i + 1).equals(ingredients.substring(i + 1, 2*i + 2))) {
      dp[2*i + 1] = dp[ i ] + 1;
    }
  }

  return dp[n - 1];
  }

  /**
   * Returns true if the tests pass. Otherwise, false.
   */
  private boolean doTestsPass()
  {
  return 
       minimalSteps("ABABCABABCD") == 6;
  }

  /**
   * Execution entry point.
   */
  public static void main( String[] args )
  {
  MagicPotion solution = new MagicPotion( );
  if ( solution.doTestsPass( ) )
  {
    System.out.println( "All tests passed" );
  }
  else
  {
    System.out.println( "Tests failed" );
  }
  }
}