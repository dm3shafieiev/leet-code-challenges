package com.company;

import java.util.HashSet;
import java.util.Set;

public class IntersectTwoArrays_SETS {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int elem : nums1) {
      set1.add(elem);
    }

    for (int elem : nums2) {
      set2.add(elem);
    }

    if (set1.size() > set2.size()) {
      return retainAll(set1, set2);
    } else {
      return retainAll(set2, set1);
    }
  }

  private int[] retainAll(Set<Integer> set1, Set<Integer> set2) {

    set1.removeIf(integer -> !set2.contains(integer));

    int[] result = new int[set1.size()];

    int index = 0;

    for (Integer elem : set1) {
      result[index++] = elem;
    }

    return result;
  }

}
