package code.blind75.utils;

public class BinaryTreeMaximumPathSum {
  static int maxPathSumVal;
  public static void main(String[] a) {
    TreeNode root = new TreeNode(-10);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println("The maximum path sum for this binary tree is : " + maxPathSum(root));
  }
  public static int maxPathSum(TreeNode root) {
    maxPathSumVal = Integer.MIN_VALUE;
    maxPathSumHelper(root);
    return maxPathSumVal;
  }
  private static int maxPathSumHelper(TreeNode node) {
    if (node == null) return 0;
    int left = Math.max(0, maxPathSumHelper(node.left));
    int right = Math.max(0, maxPathSumHelper(node.right));

    maxPathSumVal = Math.max(maxPathSumVal, left + right + node.val);
    return Math.max(left, right) + node.val;
  }
}
