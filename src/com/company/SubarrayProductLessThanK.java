package com.company;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

  public static void main(String[] args) {
    findSubarrays(new int[]{8, 2, 1, 6, 5}, 30);
  }
  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();

    int left = 0;
    int product = 1;

    for(int right = 0; right < arr.length; right++) {

      product *= arr[right];

      while(product >= target && left < arr.length) {

        product /= arr[left++];

      }

      List<Integer> list = new ArrayList<>();

      for(int pointer = right; pointer >= left; pointer--) {

        list.add(0, arr[pointer]);
        subarrays.add(new ArrayList<>(list));
      }



    }

    return subarrays;
  }



}
