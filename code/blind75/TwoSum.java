package code.blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSum {
  public static int[] twoSum(int[] array, int target) {
    Map<Integer,Integer> indexMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for(int i=0; i<array.length; i++) {
      if (!indexMap.containsKey(target - array[i])) {
        indexMap.put(array[i],i);
      } else {
        result.add(indexMap.get(target - array[i]));
        result.add(i);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
  public static void main(String[] args) {
    int[] array = {2,7,11,15};
    int target = 9;
    System.out.println("The indexes for the target are :");
    int[] result = twoSum(array, target);
    for (int a: result) {
      System.out.println(a+ " ");
    }
  }
}
