package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {


  //TC: (N*2^N) SC: O(N)
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for(int index = 0; index <= nums.length; index++) {
      backtracking(nums, index, result, new ArrayList<>(), 0);
    }

    return result;

  }

  public void backtracking(int [] nums, int n, List<List<Integer>> result, List<Integer> list, int start) {

    if(list.size() == n) {
      result.add(new ArrayList<>(list));
      return;
    }

    for(int index = start; index < nums.length; index++) {

      if (index != start && nums[index] == nums[index - 1]) {
        continue;
      }

      list.add(nums[index]);

      backtracking(nums, n, result, list, index + 1);

      list.remove(list.size() - 1);
    }

  }

}
