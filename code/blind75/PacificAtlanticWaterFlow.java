package code.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PacificAtlanticWaterFlow {
  public static void main(String[] args) {
    int[][] heights = {
        {1,2,2,3,5},
        {3,2,3,4,4},
        {2,4,5,3,1},
        {6,7,1,4,5},
        {5,1,1,2,4}
    };
    System.out.println("he points where the water can flow to both oceans are : ");
    for (List<Integer> cell: pacificAtlantic(heights)) {
      System.out.println(cell.toString());
    }
  }
  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    boolean[][] pacificOcean = new boolean[heights.length][heights[0].length];
    boolean[][] atlanticOcean = new boolean[heights.length][heights[0].length];
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i<heights[0].length;i++) {
      dfs(0,i,heights,pacificOcean,heights[0][i]);
      dfs(heights.length-1,i,heights,atlanticOcean,heights[heights.length-1][i]);
    }
    for (int i = 0; i<heights.length;i++) {
      dfs(i,0,heights,pacificOcean,heights[i][0]);
      dfs(i,heights[0].length-1,heights,atlanticOcean,heights[i][heights[0].length-1]);
    }
    for (int i = 0;i<heights.length;i++) {
      for (int j = 0;j<heights[0].length;j++) {
        if (pacificOcean[i][j] && atlanticOcean[i][j]) {
          result.add(new ArrayList<>(Arrays.asList(i,j)));
        }
      }
    }
    return result;
  }

  private static void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prevHeight) {
    if ( r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || ocean[r][c] || prevHeight > heights[r][c])
      return;

    ocean[r][c] = true;
    dfs(r+1,c,heights,ocean,heights[r][c]);
    dfs(r-1,c,heights,ocean,heights[r][c]);
    dfs(r,c+1,heights,ocean,heights[r][c]);
    dfs(r,c-1,heights,ocean,heights[r][c]);
  }
}
