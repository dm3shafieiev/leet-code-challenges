package com.company;

public class BestTimeToBuyAndSellStock_Iterative {
  public int maxProfit(int[] prices) {
    int min = prices[0];
    int max_profit = 0;

    for(int i = 1; i < prices.length; i++) {

      if(prices[i] < min) {
        min = prices[i];
      }else {
        max_profit = Math.max((prices[i] - min), max_profit);
      }

    }

    return max_profit;
  }

  //TC: O(n) SC: O(1)
}
