package code.blind75;

import java.util.Arrays;


public class BestTimeToBuySellStock {
  public static void main(String[] args) {
    int[][] prices = {{2,1,2,1,0,1,2},{7,1,5,3,6,4},{7,6,4,3,1},{2,1,4}};
    for (int[] price : prices) {
      System.out.println("The maximum profit for " + Arrays.toString(price) + " is "+ maxProfit(price));
    }
  }
  static int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) return 0;
    int maxProfit = 0;
    int left = 0;
    int right = left + 1;

    while (right < prices.length) {
        if (prices[left] < prices[right] ) {
          maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        }
        else {
          left = right;
        }
        right++;
      }
    return maxProfit;
  }
}
