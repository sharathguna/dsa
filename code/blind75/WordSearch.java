package code.blind75;

public class WordSearch {
  public static void main(String[] a) {
    char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    String[] words = {"SEE","ABCCED","ABCD"};
    for (String word : words) {
      System.out.println("The word " + word + " existing in the matrix below is : " + exist(matrix, word));
    }
    for (char[] chars : matrix) {
      for(char ch : chars) {
        System.out.print(ch + " ");
      }
      System.out.println();
    }
  }
  public static boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0;i<board.length;i++) {
      for (int j = 0;j<board[i].length;j++) {
        if (word.charAt(0) == board[i][j] && searchHelper(board,i,j,0,visited,word)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean searchHelper(char[][] board, int i, int j, int index, boolean[][] visited, String word) {
    if (word.length() == index)
      return true;
    if (i < 0 || i>= board.length || j<0 || j>= board[0].length || visited[i][j] || word.charAt(index) != board[i][j])
      return false;
    visited[i][j] = true;
    if (searchHelper(board,i+1,j,index+1,visited,word) ||
            searchHelper(board,i-1,j,index+1,visited,word) ||
            searchHelper(board,i,j+1,index+1,visited,word) ||
            searchHelper(board,i,j-1,index+1,visited,word)) {
      return true;
    }
    visited[i][j] = false;
    return false;
  }
}
