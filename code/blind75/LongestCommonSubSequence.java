package code.blind75;

import java.util.Arrays;


public class LongestCommonSubSequence {
  public static void main(String[] args) {
    String text1 = "abcde", text2 = "ace";
    System.out.println("The longest common subsequence between " + text1 + " and " + text2 + " is : " + longestCommonSubsequence(text1, text2));
  }
  public static int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()+1][text2.length()+1];
    for (int[] arr : dp) {
      Arrays.fill(arr, 0);
    }
    for (int i = text1.length() - 1; i>=0; i--) {
      for (int j = text2.length() - 1; j>=0; j--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = 1 + dp[i+1][j+1];
        }
        else {
          dp[i][j] = Math.max(dp[i+1][j] , dp[i][j+1]);
        }
      }
    }
    return dp[0][0];
  }
}
