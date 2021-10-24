package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static void main(String[] args) {
        int sum = 6;
        int[] array = {3, 2, 4};
        System.out.println(Arrays.toString(findSumIndexOnePassMap(array, sum)));
    }

    private static int[] findSumIndexPAir(int sum, int[] array) {
        int[] originalOrderArray = Arrays.copyOf(array, array.length);


        Arrays.sort(array);

        for (int cursor = 0; cursor < array.length - 1; cursor++) {
            int secondValueIndex = Arrays.binarySearch(array, sum - array[cursor]);
            if (secondValueIndex > -1) {
                return new int [] {cursor, arrayToMap(array[secondValueIndex], originalOrderArray)};
            }
        }

        return new int[0];
    }

    private static int arrayToMap(int i, int[] original) {
        for (int index = 0; index < original.length; index++) {
            if (original[index] == i) {
                return index;
            }
        }
        return -1;
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

