package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new LinkedHashMap<>();

    for(int pointer = 0; pointer < s.length(); pointer++) {
      map.compute(s.charAt(pointer), (k,v) -> v == null ? 1 : v + 1);
    }

    for(int pointer = 0; pointer < s.length(); pointer++) {

      if( map.get(s.charAt(pointer)) == 1 )
        return pointer;
    }

    return -1;
  }

  //TC: O(n) SC: O(1) 'cause it's always 26 letters.

}
