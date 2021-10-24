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


}
