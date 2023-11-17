package code.blind75;

public class ClimbingStairs {
  public static void main(String[] args){
    int steps = 10;
    System.out.println("The number of distinct ways to climb " +steps+ " are "+ climbStairs(steps));
  }
  static int climbStairs(int n) {
    int[] memo = new int[n+1];
    return climbStairsHelper(n,memo);
  }
  static int climbStairsHelper(int n, int[] memo) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (memo[n] != 0)
      return memo[n];
    else
      memo[n] = climbStairsHelper(n-1,memo) + climbStairsHelper(n-2,memo);
    return memo[n];
  }
}
