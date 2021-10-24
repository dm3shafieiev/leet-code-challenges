package com.company;

public class PlusOne {

  public int[] plusOne(int[] digits) {

    boolean carry = true;

    for(int i = digits.length - 1; i >= 0 ; i--) {
      digits[i] = digits[i] + 1;

      if(digits[i] == 10) {
        digits[i] = 0;
      }else {
        return digits;
      }
    }


    if(digits[0] == 0) {
      int [] result = new int [digits.length + 1];
      result [0] = 1;
      return result;
    }

    return digits;

  }

  //TC: O(n) SC: O(n)

}
