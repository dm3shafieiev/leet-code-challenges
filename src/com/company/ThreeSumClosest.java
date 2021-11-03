package com.company;

import java.util.Arrays;

public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {

    Arrays.sort(nums);
    int closestSum = Integer.MAX_VALUE;


    for(int fixedPointer = 0; fixedPointer < nums.length; fixedPointer++) {

      int highPointer = nums.length - 1;
      int lowPointer = fixedPointer + 1;

      while(lowPointer < highPointer) {

        int sum = nums[lowPointer] + nums[highPointer] + nums[fixedPointer];

        if (Math.abs(target - sum) < Math.abs(closestSum)) {
          closestSum = target - sum;
        }

        if(sum < target) {
          lowPointer++;
        } else {
          highPointer--;
        }


      }

    }

    return target - closestSum;

  }

}
