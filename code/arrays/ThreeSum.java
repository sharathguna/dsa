package code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println("The Triplets that form 0 are : " + threeSum(nums));
  }
  public static List<List<Integer>> threeSum(int[] nums) {
    if (nums.length == 3) {
      if (nums[0] + nums[1] + nums[2] == 0 )
        return List.of(List.of(nums[0], nums[1], nums[2]));
    }
    List<List<Integer>> result = new ArrayList<>();
    int left;
    int right;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2;) {
      int target = -nums[i];
      left = i + 1;
      right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] == target) {
          List<Integer> tempList = List.of(nums[left], nums[right], nums[i]);
          result.add(tempList);
          while(left < right && nums[left] == nums[++left]);
          while(left < right && nums[right] == nums[--right]);
        } else if (nums[left] + nums[right] < target) {
          left++;
        } else if (nums[left] + nums[right] > target) {
          right--;
        }
      }
      while (i < nums.length - 2 && nums[i] == nums[++i]);
    }
    return result;
  }
}
