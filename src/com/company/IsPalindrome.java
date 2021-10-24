package com.company;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {


  public boolean isPalindrome(String s) {

    List<Character> charsOnlyList = new ArrayList<>();

    for (char ch : s.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        charsOnlyList.add(Character.toLowerCase(ch));
      }
    }

    for (int leftPointer = 0, rightPointer = charsOnlyList.size() - 1; leftPointer <= rightPointer; leftPointer++, rightPointer--) {

      if (!charsOnlyList.get(leftPointer).equals(charsOnlyList.get(rightPointer))) {
        return false;
      }
    }

    return true;
  }

  //TC: O(N) SC: O(N)
}
