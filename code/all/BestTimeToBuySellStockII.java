package code.all;

import java.util.Arrays;
import java.util.Map;


public class BestTimeToBuySellStockII {
  public static void main(String[] args) {
    int[][] prices = {
        {7,1,5,3,6,4},
        {1,2,3,4,5},
        {7,6,4,3,1}
    };
    for (int[] price : prices) {
      System.out.println("The maximum profit from the price series " + Arrays.toString(price) + " is : " + maxProfitDP2(price));
    }
  }
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i<prices.length; i++) {
      if (prices[i] > prices[i-1]) {
        profit += prices[i] - prices[i-1];
      }
    }
    return profit;
  }
  public static int maxProfitDP(int[] prices) {
    int bought = Integer.MIN_VALUE;
    int sold = 0;
    for (int i = 1; i <= prices.length; i++) {
      sold = Math.max(sold, bought + prices[i-1]);
      bought = Math.max(bought, sold - prices[i-1]);
    }
    return Math.max(sold,bought);
  }
  public static int maxProfitDP2(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int i =0;i<prices.length;i++) {
      for (int j = 0;j<2;j++) {
        dp[i][j] = -1;
      }
    }
    return dfs(prices,0,1,dp);
  }
  static int dfs(int[] prices, int index,int buying,int[][] dp){
    if (index >= prices.length) {
      return 0;
    }
    if (dp[index][buying] != -1) {
      return dp[index][buying];
    }
    if (buying == 0) {
      dp[index][buying] = Math.max( dfs(prices,index +1, 1, dp) + prices[index],
          dfs(prices,index+1, 0,dp));
    } else {
      dp[index][buying] = Math.max( dfs(prices,index +1 , 0, dp) - prices[index],
          dfs(prices,index+1, 1,dp));
    }
    return dp[index][buying];
  }
}
