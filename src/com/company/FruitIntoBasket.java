package com.company;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {

  public int totalFruit(int[] fruits) {
    Map<Integer, Integer> fruitsMap = new HashMap<>();

    int startPosition = 0;
    int maxFruitsPicked = 0;


    for(int pointer = 0; pointer < fruits.length; pointer++) {

      boolean isEqualToPreviousFruit = pointer != 0 && fruits[pointer] == fruits[pointer - 1];

      int indexOfFruit = isEqualToPreviousFruit ? fruitsMap.get(fruits[pointer]) : pointer;

      fruitsMap.put(fruits[pointer], indexOfFruit);

      if(fruitsMap.size() > 2) {
        startPosition = fruitsMap.get(fruits[pointer - 1]);
        fruitsMap = new HashMap<>();
        fruitsMap.put(fruits[startPosition], startPosition);
        fruitsMap.put(fruits[pointer], pointer);
      }


      maxFruitsPicked = Math.max(maxFruitsPicked, (pointer - startPosition + 1));

    }

    return maxFruitsPicked;
  }

  //Refactored version
  public int totalFruitV2(int[] fruits) {

    Map<Integer, Integer> map = new HashMap<>();

    int longestSubString = 0;
    int windowStart = 0;

    for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {

      map.put(fruits[windowEnd], map.getOrDefault(fruits[windowEnd], 0) + 1);

      while(map.size() > 2) {

        map.put(fruits[windowStart], map.get(fruits[windowStart]) - 1);
        if(map.get(fruits[windowStart]) == 0) {
          map.remove(fruits[windowStart]);
        }
        windowStart++;

      }

      longestSubString = Math.max(longestSubString, windowEnd - windowStart + 1);

    }

    return longestSubString;
  }


}
