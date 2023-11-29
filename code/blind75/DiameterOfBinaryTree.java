package code.blind75;

import code.blind75.utils.TreeNode;


public class DiameterOfBinaryTree {
  static int maxSoFar = Integer.MIN_VALUE;
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(1);
    System.out.println("The maximum Diameter of the Binary Tree is : " + diameterOfBinaryTree(root) );
  }
  static int diameterOfBinaryTree(TreeNode root) {
    diameterOfBinaryTreeHelper(root);
    return maxSoFar;
  }
  public static int diameterOfBinaryTreeHelper(TreeNode root) {
    if (root == null) return 0;
    int left = diameterOfBinaryTreeHelper(root.left) ;
    int right = diameterOfBinaryTreeHelper(root.right);
    maxSoFar = Math.max(maxSoFar, left + right);
    return Math.max(left,right) + 1;
  }


}
