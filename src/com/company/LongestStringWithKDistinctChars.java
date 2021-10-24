package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithKDistinctChars {
  public static int findLength(String s) {
    char [] arr = s.toCharArray();
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

      map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);

      while (map.size() > 2) {

        map.put(arr[windowStart], map.get(arr[windowStart]) - 1);

        if (map.get(arr[windowStart]) == 0) {
          map.remove(arr[windowStart]);
        }

        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  //TC: O(N) SC: O(1)
}
