package com.company;

public class strStr {

    public static void main(String[] args) {
        String s = "mississippi";
        String target = "issip";


        for (int pointer = 0; pointer < s.length(); pointer++) {

            for (int targetPointer = 0;
                 targetPointer < target.length() && s.charAt(targetPointer + pointer) == target.charAt(targetPointer);
                 targetPointer++) {

                if (targetPointer == target.length() - 1) {
                    System.out.println(pointer);
                    return;
                }

            }
        }

        System.out.println(-1);

    }
}
