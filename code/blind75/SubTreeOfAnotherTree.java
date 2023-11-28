package code.blind75;

import code.blind75.utils.TreeNode;


public class SubTreeOfAnotherTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(1);
//    root.left.right = new TreeNode(2);

    TreeNode subRoot = new TreeNode(1);
    subRoot.left = new TreeNode(2);
//    subRoot.right = new TreeNode(2);
    System.out.println(isSubtree(root,subRoot) ? "Valid Subtree" : "Not a Valid Subtree");
  }
  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (isSameTree(root,subRoot) || subRoot == null) return true;
    if (root == null) return false;

    return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
  }
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p==null && q==null) return true;
    if (p==null) return false;
    if (q==null) return false;
    return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
  }
}
