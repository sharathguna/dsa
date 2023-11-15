package code.blind75;

import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    List<Integer> result = spiralOrder(matrix);
    result.forEach(System.out::println);
  }
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    getSpiralArray(matrix,matrix.length,matrix[0].length,0,-1,0,1,result);
    return result;
  }
  static void getSpiralArray(int[][] matrix, int m, int n, int r, int c, int dr, int dc,List<Integer> result) {
    if (m == 0 || n ==0) {
      return;
    }
    for(int i = 0;i < n;i++) {
      r = r + dr;
      c = c + dc;
      result.add(matrix[r][c]);
    }
    getSpiralArray(matrix,n,m-1,r,c,dc,-dr,result);
  }
}
