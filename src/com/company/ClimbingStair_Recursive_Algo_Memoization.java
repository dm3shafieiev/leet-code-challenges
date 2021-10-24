package com.company;

public class ClimbingStair_Recursive_Algo_Memoization {

  public int climbStairs(int n) {
    return climb(0, n, new int [n]);
  }

  private int climb(int step, int n, int [] memo) {

    if(step > n) {
      return 0;
    }

    if(step == n) {
      return 1;
    }

    if(memo[step] > 0) {
      return memo[step];
    }

    memo[step] = climb(step + 1, n, memo) + climb(step + 2, n, memo);

    return memo[step];

  }

  //Time complexity : O(n). Size of recursion tree can go upto n.
  //
  //Space complexity : O(n). The depth of recursion tree can go upto n.

}
