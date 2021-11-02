package com.company;

import java.util.TreeMap;

public class IntegerToRoman {


  public String intToRoman(int num) {

    TreeMap<Integer, String> arabicToRome = new TreeMap<>() {
      {
        put(1, "I");
        put(4 ,"IV");
        put(5 ,"V");
        put(9 ,"IX");
        put(10 ,"X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
      }
    };

    StringBuilder result = new StringBuilder();

    while(num > 0) {

      for(Integer number: arabicToRome.descendingKeySet()) {

        if(num >= number) {
          num = num - number;
          result.append(arabicToRome.get(number));
          break;
        }
      }
    }

    return result.toString();
  }

}
