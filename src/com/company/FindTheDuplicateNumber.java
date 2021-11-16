package com.company;

public class FindTheDuplicateNumber {

  //TC: O(n) SC: O(1)
  public int findDuplicate(int[] nums) {

    int pointer = 0;

    while(pointer < nums.length) {

      int val = nums[pointer];

      if(val != pointer + 1 && val != nums[val - 1]) {

        int temp = nums[val - 1];
        nums[val - 1] = val;
        nums[pointer] = temp;

      }else {
        pointer++;
      }

    }


    return nums[pointer - 1];
  }
}
