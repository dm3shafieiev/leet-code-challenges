package com.company;

public class StringToIntegerAtoi {

  //TC: O(n) SC: O(1)
  public int myAtoi(String s) {

    char [] arr = s.trim().toCharArray();
    char plus = '+';
    char minus = '-';


    if(arr.length == 0 || (!Character.isDigit(arr[0]) && arr[0] != plus && arr[0] != minus)) {
      return 0;
    }

    int result = 0;
    int validCharsCount = 0;
    boolean isPositive = true;


    for(char ch: arr) {

      if(!Character.isDigit(ch) && validCharsCount > 0) {
        break;
      }else if(ch == plus || ch == minus) {

        isPositive = ch == plus;
        validCharsCount++;

      }  else if(Character.isDigit(ch)) {

        int value = Character.getNumericValue(ch);
        long temp = result;
        temp = temp * 10 + value;

        if(isPositive && temp > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }else if(!isPositive && (temp * -1) < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }

        result = (int) temp;
        validCharsCount++;
      }
    }

    return isPositive ? result : result * -1 ;

  }

}
