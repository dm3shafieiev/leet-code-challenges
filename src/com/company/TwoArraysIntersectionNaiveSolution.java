package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoArraysIntersectionNaiveSolution {

  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    List<Integer> auxList = new ArrayList<>();

    int firstArrPointer = 0;
    int secondArrPointer = 0;

    while(firstArrPointer < nums1.length && secondArrPointer < nums2.length) {
      if(nums1[firstArrPointer] == nums2[secondArrPointer] ) {
        if(auxList.isEmpty() ||
            (auxList.get(auxList.size() - 1) != nums1[firstArrPointer] )) {
          auxList.add(nums1[firstArrPointer]);
        }

        firstArrPointer++;
        secondArrPointer++;

      }else if( nums1[firstArrPointer] <  nums2[secondArrPointer]){
        firstArrPointer++;
      }else {
        secondArrPointer++;
      }
    }

    int [] result = new int [auxList.size()];

    for(int i = 0; i< result.length; i++) {
      result[i] = auxList.get(i);
    }

    return result;
  }

  //TC O(nlogn + mLogm) SC O(n+m)

}
