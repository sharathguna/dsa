package code.blind75;

import code.all.MaximumWidthOfBinaryTree;
import code.all.MaximumWidthOfBinaryTree.Pair;
import java.util.LinkedList;
import java.util.Queue;


public class NumberOfIslands {
  public static void main(String[] args) {
    char[][] grid = {
        {'1','1','0','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','1','1','0'}
    };
    for (char[] chars : grid) {
      for (char ch : chars) {
        System.out.print(ch + " ");
      }
      System.out.println();
    }
    System.out.println("The number of islands in the above grid is " + numIslandsBFS(grid));
  }
  public static int numIslands(char[][] grid) {
    int count = 0;
    for (int i=0;i< grid.length;i++) {
      for (int j=0;j< grid[0].length;j++) {
        if (grid[i][j] == '1') {
          dfs(grid,i,j);
          count++;
        }
      }
    }
    return count;
  }
  static void dfs(char[][] grid, int i, int j) {
    if (i<0 || j<0 ||
        i>=grid.length || j>= grid[0].length ||
        grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i+1, j);
    dfs(grid, i-1, j);
    dfs(grid, i, j+1);
    dfs(grid, i, j-1);
  }
  public static int numIslandsBFS(char[][] grid) {
    int count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i=0;i< grid.length;i++) {
      for (int j=0;j< grid[0].length;j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          bfs(grid,i,j,visited);
          count++;
        }
      }
    }
    return count;
  }

  static void bfs(char[][] grid, int i, int j, boolean[][] visited) {
    Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(i,j));
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      Pair<Integer,Integer> pair = queue.poll();
      int r = pair.getKey();
      int c = pair.getValue();
      int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
      for (int[] dir : directions) {
        int row = r + dir[0];
        int col = c + dir[1];

        if ( (row >= 0 && row < grid.length ) && (col >= 0 && col < grid[0].length ) &&
            !visited[row][col] && grid[row][col] == '1') {
          queue.add(new Pair<>(row,col));
          visited[row][col] = true;
        }
      }
    }
  }
}
