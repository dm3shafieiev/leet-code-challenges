package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

  public static void main(String[] args) {

  }

  public boolean isValid(String s) {
    final List<Character> openers = List.of('{', '[', '(');
    final HashMap<Character, Character> charactersMap = new HashMap<>() {
      {
        put('}', '{');
        put(']', '[');
        put(')', '(');
      }
    };

    final Stack<Object> activeOpeners = new Stack<>();
    final char[] chars = s.toCharArray();

    if (!openers.contains(chars[0])) {
      return false;
    }

    for (int n = 0; n < chars.length; n++) {
      if (openers.contains(chars[n])) {
        activeOpeners.push(chars[n]);
      } else if (activeOpeners.isEmpty() || !charactersMap.get(chars[n])
          .equals(activeOpeners.pop())) {
        return false;
      }
    }

    return activeOpeners.isEmpty();
  }
}

