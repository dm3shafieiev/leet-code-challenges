package com.company;

public class ClimbingStair_NON_Recursive_Algo_DP {

  public int climbStairs(int n) {

    if(n == 1) {
      return 1;
    }

    int[] climbOptions = new int [n + 1];

    climbOptions[1] = 1;
    climbOptions[2] = 2;

    for(int step = 3; step <= n; step ++) {

      climbOptions[step] = climbOptions[step - 1] + climbOptions[step - 2];

    }

    return climbOptions[n];
  }

  //Time complexity : O(n). Size of recursion tree can go upto n.
  //
  //Space complexity : O(n). The depth of recursion tree can go upto n.

}
