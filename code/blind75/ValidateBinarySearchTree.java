package code.blind75;

import code.utils.TreeNode;


public class ValidateBinarySearchTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(1);

    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(4);
    root2.left.left = null;
    root2.left.right = null;
    root2.right = new TreeNode(6);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(7);

    TreeNode root3 = new TreeNode(0);
    System.out.println("The given tree is " + (isValidBST(root2) ? "a valid" : "an invalid") + " Binary Search Tree ");
  }
  public static boolean isValidBST(TreeNode root) {
    return isValidBST(root,null,null);
  }
  static boolean isValidBST(TreeNode root,Integer min, Integer max) {
    if (root == null) return true;
    if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
    return isValidBST(root.left,min,root.val) && isValidBST(root.right, root.val,max);
  }

}
