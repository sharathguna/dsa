package code.all;

import java.util.Arrays;


public class BuyAndSellStockCooldown {
  public static void main(String[] args) {
    int[][] prices  = { {1,2,3,0,2}, {1} };
    for (int[] price : prices) {
      System.out.println("The maximum profit from the prices " + Arrays.toString(price) + " is : " + maxProfit(price));
    }
  }
  public static int maxProfit(int[] prices) {
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
      dp[index][buying] = Math.max( dfs(prices,index + 2, 1, dp) + prices[index],
                                        dfs(prices,index+1, 0,dp));
    } else {
      dp[index][buying] = Math.max( dfs(prices,index + 1, 0, dp) - prices[index],
          dfs(prices,index+1, 1,dp));
    }
    return dp[index][buying];
  }
}
