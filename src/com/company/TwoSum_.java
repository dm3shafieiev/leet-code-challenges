package com.company;

import java.util.HashMap;
import java.util.Map;

class TwoSum_ {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> diffs = new HashMap<>();
    for(int n = 0; n < nums.length; n ++ ) {
      diffs.put(target - nums[n], n);
    }

    for(int n = 0; n < nums.length; n ++ ) {
      if(diffs.containsKey(nums[n])) {
        return new int [] {n, diffs.get(nums[n])};
      };
    }
    throw new IllegalArgumentException();
  }
}
