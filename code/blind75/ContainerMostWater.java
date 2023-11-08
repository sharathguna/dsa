package code.blind75;

public class ContainerMostWater {
  public static void main(String[] args) {
    int[] height = {1,2,6,8};
    System.out.println("The container with most water is : " + maxArea(height));
  }
  public static int maxArea(int[] height) {
    if (height.length == 2) return Math.min(height[0], height[1]);
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int areaSoFar = Math.min(height[left], height[right]) * (right - left);
      if (areaSoFar > maxArea) {
        maxArea = areaSoFar;
      }
      if (height[left] < height[right] ) {
        left++;
      }
      else {
        right--;
      }
    }
    return maxArea;
  }
}
