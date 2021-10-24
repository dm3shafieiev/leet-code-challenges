package com.company;

import java.util.Arrays;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};

        int firstMatch = 0;
        int val = 2;

        Arrays.sort(array);

        for (int pointer = 0; pointer < array.length && array[firstMatch] != val; pointer++) {

            if (array[pointer] == val) {
                firstMatch = pointer;
            }
        }

        for (int pointer = firstMatch; pointer < array.length; pointer++) {
            if (array[pointer] != val) {
                array[firstMatch++] = array[pointer];
            }
        }

        System.out.println(firstMatch);
        System.out.println(Arrays.toString(array));
    }

}
