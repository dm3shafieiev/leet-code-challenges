package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Example :
 * Input: nums = [3,2,3]
 * Output: 3
 */
public class MajorityElementHashMap {

  public int majorityElement(int[] nums) {

    if(nums.length == 1) {
      return nums[0];
    }

    Map<Integer,Integer> map = new HashMap<>();

    for(int pointer = 0; pointer < nums.length; pointer++) {
      map.compute(nums[pointer], (k,v) -> v == null ? 1 : ++v);
    }

    Map.Entry<Integer,Integer> majorityEntry = null;

    for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
      if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        majorityEntry = entry;
      }
    }

    return majorityEntry.getKey();
  }

  //TC: O(n) SC: O(n)

}
