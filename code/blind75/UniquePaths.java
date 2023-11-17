package code.blind75;

public class UniquePaths {
  public static void main(String[] args) {
    System.out.println("Enter the number of rows : ");
    int m = Integer.parseInt(args[0]);
    System.out.println("\nEnter the number of columns : ");
    int n = Integer.parseInt(args[1]);
    System.out.println("\nThe number of paths from start to end are : " + uniquePaths(m, n));
  }
  private static int uniquePaths(int m, int n) {
    if (m == 0 || n == 0) return 0;
    if (m == 1 || n == 1) return 1;
    int[][] dpPaths = new int[m][n];

    for (int i = 0; i<m; i++) dpPaths[i][0] = 1;
    for (int i = 0; i<n; i++) dpPaths[0][i] = 1;

    for (int i = 1;i<m;i++) {
      for (int j = 1;j<n;j++) {
        dpPaths[i][j] = dpPaths[i][j-1] + dpPaths[i-1][j];
      }
    }
    return dpPaths[m-1][n-1];
  }
}
