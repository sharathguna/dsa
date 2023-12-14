package code.blind75;

import java.util.Arrays;


public class HouseRobber {
  public static void main(String[] args) {
    int[][] nums = {
        {1,2,3,1},
        {2,7,9,3,1}
    };
    for (int[] num : nums) {
      System.out.println("The maximum amount that can be robbed from the houses with values " + Arrays.toString(num) + " is : " + rob(num));
    }
  }
  public static int rob(int[] nums) {
    int rob1 = 0 , rob2 =0;
    for (int a : nums) {
      int temp = Math.max(rob2, a + rob1);
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2;
  }
}
