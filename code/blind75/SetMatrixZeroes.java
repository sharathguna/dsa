package code.blind75;

import java.util.HashMap;
import java.util.Map;


public class SetMatrixZeroes {
  public static void main(String[] a) {
    int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
    int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    int[][] matrix3 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
    System.out.println("Matrix Before Zeroing is ");
    printMatrix(matrix1);
    setZeroes(matrix1);
    System.out.println("Matrix After Zeroing is ");
    printMatrix(matrix1);
    System.out.println("Matrix Before Zeroing is ");
    printMatrix(matrix2);
    setZeroes(matrix2);
    System.out.println("Matrix After Zeroing is ");
    printMatrix(matrix2);
    System.out.println("Matrix Before Zeroing is ");
    printMatrix(matrix3);
    setZeroes(matrix3);
    System.out.println("Matrix After Zeroing is ");
    printMatrix(matrix3);
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] ints : matrix) {
      for (int num : ints) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  public static void setZeroes(int[][] matrix) {
    Map<Integer,Boolean> zeroMapRow = new HashMap<>();
    Map<Integer,Boolean> zeroMapColumn = new HashMap<>();
    for (int i =0; i<matrix.length;i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          zeroMapRow.put(i,true);
          zeroMapColumn.put(j,true);
        }
      }
    }
    for (int i =0; i<matrix.length;i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if ((zeroMapRow.containsKey(i) && zeroMapRow.get(i)) || (zeroMapColumn.containsKey(j) && zeroMapColumn.get(j))) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
