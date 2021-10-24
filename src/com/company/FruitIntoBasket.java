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

  public static int findLength(char[] arr) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the frequency map
      while (fruitFrequencyMap.size() > 2) {
        fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
        if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
          fruitFrequencyMap.remove(arr[windowStart]);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
}
