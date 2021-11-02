package com.company;

public class ContainerWithMostWater {

 //TC: O(n) SC: O(1)
  public int maxArea(int[] height) {

    int leftPointer = 0;
    int rightPointer = height.length - 1;
    int maxArea = 0;

    while(leftPointer != rightPointer) {

      int minHeight = Math.min(height[leftPointer], height[rightPointer]);
      int area = minHeight * (rightPointer - leftPointer);
      maxArea = Math.max(maxArea, area);


      if(minHeight == height[leftPointer]) {
        leftPointer++;
      }else {
        rightPointer--;
      }

    }

    return maxArea;

  }
}
