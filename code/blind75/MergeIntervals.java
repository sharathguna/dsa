package code.blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class MergeIntervals {
  public static void main(String[] args) {
    int[][] arr1 = {{1,3},{2,6},{8,10},{15,18}};
    int[][] arr2 = {{1,4},{4,5}};
    int[][] arr3 = {{3,8},{2,6},{4,5},{9,10}};
    int[][] arr4 = {{0,1}};
    System.out.println("Intervals after merging the array is " + Arrays.deepToString(arr1));
    System.out.println(Arrays.deepToString(merge(arr1)));
    System.out.println("Intervals after merging the array is " + Arrays.deepToString(arr2));
    System.out.println(Arrays.deepToString(merge(arr2)));
    System.out.println("Intervals after merging the array is " + Arrays.deepToString(arr3));
    System.out.println(Arrays.deepToString(merge(arr3)));
    System.out.println("Intervals after merging the array is " + Arrays.deepToString(arr4));
    System.out.println(Arrays.deepToString(merge(arr4)));

  }
  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing( o->o[0]));
    if (intervals.length == 1) return intervals;
    ArrayList<int[]> resultList = new ArrayList<>();
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    Collections.addAll(queue, intervals);
    while (queue.size() >= 2) {
      int[] current = queue.poll();
      int[] next = queue.poll();
      int[] val = new int[2];
      if (current[1] >= next[0]) {
        int first = Math.min(current[0],next[0]);
        int last = Math.max(current[1],next[1]);
        val[0] = first;
        val[1] = last;
        queue.addFirst(val);
      } else {
        resultList.add(current);
        queue.addFirst(next);
      }
    }
    while (!queue.isEmpty()) {
      int[] remaining = queue.poll();
      resultList.add(remaining);
    }
    return resultList.toArray(new int[0][2]);
  }
}
