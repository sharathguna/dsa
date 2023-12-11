package code.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumIV {
  static int result;
  public static void main(String[] args) {
    int[] candidates = {1,2,3};
    int target = 4;
    System.out.println("The number of combinations to form sum "+ target +" from  "+ Arrays.toString(candidates)+ " are " + combinationSum(candidates,target));
  }
  public static int combinationSum4(int[] candidates, int target) {
    Arrays.sort(candidates);
    findCombination(target,candidates,new ArrayList<>());
    return result;
  }

  public static void findCombination(int target, int[] candidates, List<Integer> tempList) {
    if (target == 0) {
      result++;
    } else if(target > 0) {
      for (int candidate : candidates) {
        tempList.add(candidate);
        findCombination(target - candidate, candidates, tempList);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static int combinationSum(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    //1,2,3 --> 4
    for(int i = 1; i <= target; i++) {
      for(int j : nums) {
        int remainingSum = i - j;
        if(remainingSum >= 0) {
          dp[i] += dp[remainingSum];
        }
      }
    }
    return dp[target];
  }
}
