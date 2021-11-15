package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HappyNumber {

  //TC:O(N) SC: O(N)
  public boolean isHappy(int n) {

    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    queue.add(n);

    while(!queue.isEmpty()) {

      Integer val = queue.poll();
      int sum = 0;

      while(val > 0) {
        int digit = val % 10;
        sum += digit * digit;
        val = val / 10;
      }

      if(sum == 1) {
        return true;
      }

      if(set.contains(sum)) {
        return false;
      }

      set.add(sum);
      queue.add(sum);

    }

    return false;
  }

}
