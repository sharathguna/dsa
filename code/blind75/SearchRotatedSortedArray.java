package code.blind75;

import java.util.Arrays;


public class SearchRotatedSortedArray {
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    int target = 5;

    System.out.println("The index of " + target + " in "+ Arrays.toString(arr)+ " : is " + search(arr, target));
  }

  public static int search(int[] nums, int target) {
    if (nums.length == 1 && nums[0] != target) return -1;
    return searchHelper(nums, target, 0, nums.length - 1);
  }

  static int searchHelper(int[] nums, int target, int left, int right) {
    if (left == right && nums[left] != target) return -1;
    int mid = (left + right) / 2;
    if (target == nums[mid]) {
      return mid;
    }
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target <= nums[mid]) {
        return searchHelper(nums, target, left, mid -1 );
      } else {
        return searchHelper(nums,target,mid+1, right);
      }
    } else {
      if (nums[mid] <= target && target <= nums[right]) {
        return searchHelper(nums, target, mid +1, right);
      } else {
        return searchHelper(nums, target, left, mid-1);
      }
    }
  }
}
