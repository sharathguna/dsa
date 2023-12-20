package code.all;

import code.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


public class MaximumLevelSumOfABinaryTree {
  public static void main(String[] args){
    TreeNode root = new TreeNode(-100);
    root.left = new TreeNode(-200);
    root.right = new TreeNode(-300);
    root.left.left = new TreeNode(-20);
    root.left.right = new TreeNode(-5);
    root.right.left = new TreeNode(-10);
//    root.right.right = new TreeNode(-89388);
//    root.right.right.right = new TreeNode(-32127);
    System.out.println("The level with the maximum sum is  : " + maxLevelSum(root));
  }
  public static int maxLevelSum(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    int maxSum = Integer.MIN_VALUE;
    int maxLevel = 0;
    while (!queue.isEmpty()) {
      level++;
      int len = queue.size();
      int localSum = 0;
      while (len-- > 0) {
        TreeNode node = queue.poll();
        localSum += node.val;
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      if (localSum > maxSum) {
        maxSum = localSum;
        maxLevel = level;
      }
    }
    return maxLevel;
  }
}
