package com.company;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static void main(String[] args) {

    }

    private static int[] findSumIndexOnePassMap(int[] original, int sum) {

        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int index = 0; index < original.length; index++) {

            int numberToLoopUp = sum - original[index];

            if (numToIndexMap.containsKey(numberToLoopUp)) {
                return new int [] {numToIndexMap.get(numberToLoopUp), index};
            }

            numToIndexMap.put(original[index], index);
        }
        return new int [0];
    }
}
