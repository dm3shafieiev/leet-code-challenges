package com.company;

public class SquaresOfASortedArray {

  //TC: O(n) SC O(n)
  public int[] sortedSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int sqPointer = arr.length - 1;
    int left = 0;
    int right = arr.length - 1;


    while(left <= right) {

      if(Math.abs(arr[left]) > Math.abs(arr[right])) {
        squares[sqPointer--] = (int) Math.pow(arr[left], 2);
        left++;
      }else {
        squares[sqPointer--] = (int)Math.pow(arr[right], 2);
        right--;
      }

    }

    return squares;
  }

}
