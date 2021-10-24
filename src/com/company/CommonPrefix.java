package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};


        int minLength = Stream.of(strs)
                .mapToInt(String::length)
                .min()
                .getAsInt();


        List<char[]> chars = Stream.of(strs)
                .map(String::toCharArray)
                .collect(Collectors.toList());



        StringBuilder result = new StringBuilder();
        boolean isEqual = true;

        for (int pointer = 0; pointer < minLength && isEqual; pointer++) {

            for (int innerPointer = 0, innnerPointer2 = 1; innnerPointer2 < chars.size() && isEqual; innnerPointer2++, innerPointer++) {
                char[] wordAsArray = chars.get(innerPointer);
                char[] wordAsArrayNext = chars.get(innnerPointer2);

                isEqual = wordAsArray[pointer] == wordAsArrayNext[pointer];
            }

            if(isEqual) {
                result.append(chars.get(0)[pointer]);
            }
        }


        System.out.println(result.toString());
    }

}
