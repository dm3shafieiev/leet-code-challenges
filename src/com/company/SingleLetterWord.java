package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleLetterWord {


    public static void main(String[] args) {
        String input = "AAA A ABABA\n" +
                "BABAB B ABAB C JAJA";

        List<String> result = Stream.of(input.split(" "))
                .filter(word -> word.length() == 1)
                .collect(Collectors.toList());

        System.out.println(result);

    }

}
