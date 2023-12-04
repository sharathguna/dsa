package code.blind75;

import java.util.Arrays;


public class CoinChange {
  public static void main(String[] args) {
    int[][] coins = {{2,3,5},{3,4,7}};
    int amount = 5;
    for (int[] coin : coins) {
      System.out.println("The minimum number of coins to reach " + amount + " from " + Arrays.toString(coin) + " is : " + coinChangeTD(coin,amount));
    }
  }
  public static int coinChangeBU(int[] coins, int amount) {
    if (amount == 0) return 0;
    int[] dp = new int[amount+1];
    for (int i=1; i<dp.length ; i++) {
      dp[i] = amount + 1;
    }
    dp[0] = 0;
    for (int amt = 1; amt <=amount; amt++) {
      for (int coin : coins) {
        if (amt - coin >= 0) {
          dp[amt] = Math.min(dp[amt], 1 + dp[amt-coin]);
        }
      }
    }
    return dp[amount] != amount+1 ? dp[amount] : -1 ;
  }
  public static int coinChangeTD(int[] coins,int amount) {
    if (amount == 0) return 0;
    int[] dp = new int[amount+1];
    Arrays.fill(dp,-1);
    int ans = coinCount(coins,amount,dp);
    return ans != Integer.MAX_VALUE ? ans : -1;
  }

  private static int coinCount(int[] coins,int amount,int[] dp) {
    if (amount == 0) {
      return 0;
    }
    if (amount <0) {
      return Integer.MAX_VALUE;
    }
    if (dp[amount] != -1) {
      return dp[amount];
    }
    int min = Integer.MAX_VALUE;

    for (int coin : coins) {
      int ans = coinCount(coins, amount - coin, dp);
      if (ans != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + ans);
      }
    }
    dp[amount] = min;
    return dp[amount];
  }
}
