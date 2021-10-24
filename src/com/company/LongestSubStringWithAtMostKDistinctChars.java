package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtMostKDistinctChars {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {

    char [] arr = s.toCharArray();
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

      map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);

      while (map.size() > k) {

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
}
