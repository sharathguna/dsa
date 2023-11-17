package code.blind75.utils;

import java.util.Arrays;
import java.util.Comparator;


public class ComparatorSort {
  public static void main(String[] args) {
    int[][] arrays= {{1,3},{2,6},{0,5}};
    System.out.println("Before Sorting");
    for(int[] array : arrays) {
      System.out.println(Arrays.toString(array));
    }
    Arrays.sort(arrays, Comparator.comparingInt(o -> o[0]));
    System.out.println("After Sorting");
    for(int[] array : arrays) {
      System.out.println(Arrays.toString(array));
    }
  }
}
