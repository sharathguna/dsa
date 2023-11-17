package code.blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class InsertInterval {
  public static void main(String[] args) {
    int[][] intervals = {{1,3},{6,9}};
    int[] newInterval = {2,5};
    System.out.println("Before inserting " + Arrays.toString(newInterval) + " into "+ Arrays.deepToString(intervals));
    System.out.println("After inserting " + Arrays.deepToString(insert(intervals, newInterval)));
  }
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] mergedArray = Arrays.copyOf(intervals,intervals.length + 1);
    mergedArray[mergedArray.length-1] = newInterval;
    Arrays.sort(mergedArray, Comparator.comparing( o->o[0]));
    if (mergedArray.length == 1) return mergedArray;
    ArrayList<int[]> resultList = new ArrayList<>();
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    Collections.addAll(queue, mergedArray);
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
