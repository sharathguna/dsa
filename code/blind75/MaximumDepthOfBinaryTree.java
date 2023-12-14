package code.blind75;

import code.utils.TreeNode;


public class MaximumDepthOfBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println("The maximum depth of the binary tree is : " + maxDepth(root));
  }
  public static int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    else
      return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
  }
}
