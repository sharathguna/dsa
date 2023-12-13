package code.blind75;

import java.util.Arrays;


public class LongestIncreasingSubSequence {
  public static void main(String[] args){
    int[][] nums = {{10,9,2,5,3,7,101,18}, {0,1,0,3,2,3}, {7,7,7,7,7,7,7}};
    for (int[] num : nums) {
      System.out.println("The longest increasing subsequence in " + Arrays.toString(num) + " is : " + lengthOfLIS(num));
    }
  }
  public static int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int max = 1;
    Arrays.fill(dp,1);
    for (int i = dp.length-1; i >= 0 ; i--) {
      for (int j = i+1; j < dp.length; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
          max = Math.max(max, dp[i]);
        }
      }
    }
    return max;
  }
}
