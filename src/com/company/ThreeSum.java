package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

  //TC: O(n2) SC: O(n)
  public List<List<Integer>> threeSum(int[] nums) {

    if(nums.length == 0) {
      return new ArrayList<>();
    }

    Map<Integer, Integer> map = new HashMap<>();
    Set<List<Integer>> result = new HashSet<>();
    Set<Integer> dublicates = new HashSet<>();

    for(int fixedPointer = 0; fixedPointer < nums.length; fixedPointer++) {

      int fixedNum = nums[fixedPointer];

      if (dublicates.add(fixedNum)) {

        for(int pointer = fixedPointer + 1; pointer < nums.length; pointer++) {

          if(map.containsKey(nums[pointer]) && (fixedNum + nums[pointer] + map.get(nums[pointer])) == 0) {

            List<Integer> triplet = Arrays.asList(fixedNum, nums[pointer], map.get(nums[pointer]));
            Collections.sort(triplet);
            result.add(triplet);
          }


          map.put(-fixedNum - nums[pointer], nums[pointer]);

        }
      }

    }
    return new ArrayList(result);
  }
}
