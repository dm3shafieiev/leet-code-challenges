package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestStringWithTwoDistinctChars {
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

  public int lengthOfLongestSubstringTwoDistinct(String s) {

    int windowStart = 0, maxLength = 2 , windowEnd = 0, stringLength = s.length();

    if (stringLength < 3) return stringLength;

    Map<Character, Integer> map = new HashMap<>();


    while(windowEnd < stringLength) {

      map.put(s.charAt(windowEnd), windowEnd++);

      if (map.size() == 3) {

        int minCharIndex = Collections.min(map.values());

        map.remove(s.charAt(minCharIndex));

        windowStart = minCharIndex + 1;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart);
    }

    return maxLength;
  }

  //TC: O(N) SC: O(1)
}
