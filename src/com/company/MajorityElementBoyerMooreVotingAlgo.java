package com.company;

public class MajorityElementBoyerMooreVotingAlgo {

  public int majorityElement(int[] nums) {
    int candidate = 0;
    int vout_count = 0;

    for(int elem : nums) {

      if(vout_count == 0) {
        candidate = elem;
      }

      vout_count += (candidate == elem) ? 1 : -1;
    }

    return candidate;

    //TC: O(n) SC: O(1)
  }

}
