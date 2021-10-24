package com.company;

import java.util.HashMap;
import java.util.Stack;

public class ValidString {


    public static void main(String[] args) {
        HashMap<Character, Character> openedToClosed = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };


        String string = "([)]";


        char[] symbols = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int pointer = 0; pointer < symbols.length; pointer++) {
            char symbol = symbols[pointer];

            if(openedToClosed.containsKey(symbol) && stack.size()!=0 &&openedToClosed.get(symbol).equals(stack.peek())) {
                stack.pop();
            }else {
                stack.push(symbol);
            }
        }

        System.out.println(stack.size());

    }

}
