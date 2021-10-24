package com.company;


public class MaxSubArray {

  public static void main(String[] args) {
    maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
  }
  public static int maxSubArray(int[] nums) {
    int currentSubArraySum = nums[0];
    int maxSubArraySum = nums[0];

    for(int i = 1; i < nums.length; i++){
      int currentNumber = nums[i];
      currentSubArraySum = Math.max(currentNumber, currentSubArraySum + currentNumber);
      maxSubArraySum = Math.max(currentSubArraySum, maxSubArraySum);
      System.out.println(String.format("currentNumber: %s; currentSubArraySum: %s; maxSubArraySum: %s;", currentNumber, currentSubArraySum, maxSubArraySum));
    }

    return maxSubArraySum;

  }
}
