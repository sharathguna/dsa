package code.blind75;

import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {
  public static void main(String[] args) {
    int[][] arr = {{1,1,1,3,3,4,3,2,4,2},{1,2,3,4}};
    for (int[] a : arr) {
      System.out.println(containsDuplicate(a) ? "Contains Duplicate" : "No Duplicate");
    }
  }
  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> numberSet = new HashSet<>(nums.length);
    for (int n : nums) {
      if (!numberSet.contains(n)) {
        numberSet.add(n);
      }
      else {
        return true;
      }
    }
    return false;
  }
}
