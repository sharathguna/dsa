package code.blind75;

public class JumpGame {
  public static void main(String[] args){
    int[][] arr = {{2,3,1,1,4},{3,2,1,0,4}};
    for (int[] array: arr) {
      System.out.println("The last index reachability is " + canJump(array));
    }
  }
  public static boolean canJump(int[] nums) {
    int lastGoodIndex = nums.length - 1;
    for (int i = nums.length - 1; i>=0; i--) {
      if ( i + nums[i] >= lastGoodIndex) {
        lastGoodIndex = i;
      }
    }
    return lastGoodIndex == 0;
  }
}
