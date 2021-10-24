package com.company;

import java.util.ArrayList;
import java.util.List;

public class NumberPolindrom {

    public static void main(String[] args) {
        int x = 10;

        System.out.println(checkIfPolindrom(x));
    }

    private static boolean checkIfPolindrom(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> numbers = new ArrayList<>();
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            numbers.add(pop);
        }
        for (int i = 0, j = numbers.size() - 1; i != j; i++, j--) {
            System.out.println();
            if (!numbers.get(i).equals(numbers.get(j))) {
                return false;
            }
        }
        return true;
    }

}
