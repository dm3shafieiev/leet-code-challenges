package com.company;

public class ReverseWordsInAStringII {

  //TC O(n) SC O(1) Reverse all words first, then whole array after
  public void reverseWords(char[] s) {

    int startOfTheWord = 0;

    for(int pointer = 0; pointer < s.length; pointer++) {

      if(s[pointer] == ' ') {

        reverse(startOfTheWord, pointer - 1, s);
        startOfTheWord = pointer + 1;
      }


    }

    reverse(startOfTheWord, s.length - 1, s);
    reverse(0, s.length - 1, s);

    return;

  }

  public void reverse(int startOfTheWord, int pointer, char[] s) {

    while(startOfTheWord < pointer) {

      char temp = s[startOfTheWord];
      s[startOfTheWord] = s[pointer];
      s[pointer] = temp;
      startOfTheWord++;
      pointer--;
    }


  }
}
