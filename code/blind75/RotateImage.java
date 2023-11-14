package code.blind75;

public class RotateImage {
  public static void main(String[] args) {
    int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println("Image before rotating : ");
    for (int[] ints : image) {
      for (int a : ints) {
        System.out.print(a+ " ");
      }
      System.out.println();
    }
    System.out.println("Image after rotating : ");
    int[][] result = rotate(image);
    for (int[] ints : result) {
      for (int a : ints) {
        System.out.print(a+ " ");
      }
      System.out.println();
    }
  }
  public static int[][] rotate(int[][] matrix) {
    for (int i =0; i<matrix.length;i++) {
      for (int j = i; j< matrix.length;j++) {
        if (i!=j) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }
    for (int i =0; i<matrix.length;i++) {
      for (int j = matrix.length-1, k = 0; j >= matrix.length/2 && k<= matrix.length/2;j--,k++) {
        int temp = matrix[i][k];
        matrix[i][k] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
    return matrix;
  }
}
