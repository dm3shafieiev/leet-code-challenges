package com.company;

public class SortColors {

  //TC: O(n) SC: O(1)
  public void sortColors(int[] arr) {

    int right = arr.length - 1;
    int left = 0;
    int pointer = 0;

    while (pointer <= right) {

      int val = arr[pointer];

      if (val == 1) {
         pointer++;
      }

      if (val == 0) {
        extracted(arr, left++, pointer++, 0);
      }

      if (val == 2) {
        extracted(arr, right--, pointer, 2);
      }

    }
  }

  private void extracted(int[] arr, int left, int pointer, int i) {
    int temp = arr[left];
    arr[left] = i;
    arr[pointer] = temp;
  }

}
