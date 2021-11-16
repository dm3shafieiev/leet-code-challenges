package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

  //TC: O(n) SC: O(1)
  public List<Integer> findDuplicates(int[] nums) {

    List<Integer> result = new ArrayList<>();
    int pointer = 0;

    while(pointer < nums.length) {

      int val = nums[pointer];

      if(val != (pointer + 1) && val != nums[val - 1] ) {

        int temp = nums[val - 1];
        nums[val - 1] = val;
        nums[pointer] = temp;

      }else {
        pointer++;
      }
    }

    for(int index = 0; index < nums.length; index++) {

      if( (index + 1) != nums[index]) {

        result.add(nums[index]);
      }

    }



    return result;

  }

}
