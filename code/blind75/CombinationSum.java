package code.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
  public static void main(String[] args) {
  int[] candidates = {2,3,6,7};
  int target = 8;
    System.out.println("The different combinations to form sum "+ target +" from  "+ Arrays.toString(candidates)+ " are :");
    List<List<Integer>> result = combinationSum(candidates, target);
    result.forEach(System.out::println);
  }
  static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    findCombinations(candidates,target,0,result,new ArrayList<>());
    return result;
  }
  private static void findCombinations(int[] array, int target,int start,List<List<Integer>> result,List<Integer> tempResult) {
    if (target < 0) {
    } else if (target == 0) {
      result.add(new ArrayList<>(tempResult));
    }
    else {
      for (int i = start;i<array.length;i++) {
        tempResult.add(array[i]);
        findCombinations(array,target-array[i],i,result,tempResult);
        tempResult.remove(tempResult.size() - 1);
      }
    }
  }
}
