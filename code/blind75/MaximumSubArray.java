package code.blind75;

public class MaximumSubArray {
  public static void main(String[] args){
    int[] array = {-2,1,-3,4,-1,2,1,-5,4};
    int[] array1 = {5,4,-1,7,8};
    int[] array2 = {-1,-2};
    System.out.println("The maximum subarray for the array : "+maxSubArray(array2));
  }
  public static int maxSubArray(int[] nums) {
    int currentMax = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int element : nums) {
      currentMax = currentMax + element;
      if (currentMax > maxSum) {
        maxSum = currentMax;
      }
      if (currentMax < 0) {
        currentMax = 0;
      }
    }
    return maxSum;
  }
}
