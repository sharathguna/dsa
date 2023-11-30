package code.blind75;

import code.blind75.utils.TreeNode;


public class LowestCommonAncestor {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    TreeNode p = new TreeNode(7);
    TreeNode q = new TreeNode(4);
    System.out.println("The common ancestor for " +q.val + " and "+ p.val + " is : " + lowestCommonAncestor(root,p,q).val );
  }
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root.val == p.val || root.val == q.val) return root;

    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);

    if (left != null && right != null) {
      return root;
    }
    else if (left == null && right!= null) {
      return right;
    } else {
      return left;
    }
  }
}
