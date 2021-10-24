package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class RomeNumbers {

    public static void main(String[] args) {

        String roman = "LVIII";

        HashMap<Character, Integer> romeToArabic = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };


        char[] nums = roman.toCharArray();
        int result = romeToArabic.get(nums[nums.length - 1]);

        for (int pointer = nums.length - 2; pointer >= 0; pointer--) {
            Integer integer = romeToArabic.get(nums[pointer + 1]);
            Integer integerNext = romeToArabic.get(nums[pointer]);
            if(integerNext < integer) {
                result+= integerNext - integer;
                pointer-=1;
            } else {
                result+=integerNext;
            }
        }

        System.out.println(result);
    }

}
