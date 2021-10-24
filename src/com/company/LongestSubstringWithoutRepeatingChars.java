package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> uniqueChars = new HashMap<Character, Integer>();
    int maxSubStringLength = 0;
    int startOfSubString = 0;

    char [] inputString = s.toCharArray();

    for(int pointer = 0; pointer < inputString.length; pointer++) {

      if(uniqueChars.containsKey(inputString[pointer])) {

        Integer previousIndexOfCurrentChar = uniqueChars.get(inputString[pointer]);
        startOfSubString = Math.max(previousIndexOfCurrentChar, startOfSubString);
      }


      maxSubStringLength = Math.max(maxSubStringLength, (pointer - startOfSubString + 1));
      uniqueChars.put(inputString[pointer], pointer + 1);

    }


    return maxSubStringLength;

  }

}
