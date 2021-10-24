package com.company;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] array = {1,1,1,2};

        int firstMatch = 0;



        for (int pointer = 1; pointer < array.length; pointer++) {
            if (array[pointer] != array[firstMatch]) {

                array[++firstMatch] = array[pointer];
            }
        }
        System.out.println(++firstMatch);
        System.out.println(Arrays.toString(array));
    }

}
