package code.blind75;

import code.blind75.utils.TreeNode;


public class BalancedBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);

    TreeNode.printTree(root);
    System.out.println(isBalanced(root) ? "a Balanced Tree" : "Not a Balanced Tree");
  }
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    if (Math.abs(rightHeight-leftHeight) > 1) return false;
    return isBalanced(root.left) && isBalanced(root.right);
  }
  static int height(TreeNode root) {
    if (root == null) return 0;
    return Math.max(height(root.left),height(root.right)) + 1;
  }
}
