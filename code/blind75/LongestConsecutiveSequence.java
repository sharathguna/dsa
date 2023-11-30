package code.blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[][] nums = {{100,4,200,1,3,2},{0,3,7,2,5,8,4,6,0,1}};
    for (int[] num : nums) {
      System.out.println("The length of longest sequence in " + Arrays.toString(num) + " is " + longestConsecutive(num) );
    }
  }
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return 1;
    Set<Integer> numSet = new HashSet<>();
    for (int n : nums) {
      numSet.add(n);
    }
    int seqCount = 0;

    for (int num : nums) {
      int leftNeighbour = num - 1;
      if (!numSet.contains(leftNeighbour)) {
        int rightNeighbour = num + 1;
        int localCount = 1;
        while (numSet.contains(rightNeighbour++)) {
          localCount++;
        }
        seqCount = Math.max(seqCount, localCount);
      }
    }
    return seqCount;
  }
}
