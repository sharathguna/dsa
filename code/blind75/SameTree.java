package code.blind75;

import code.blind75.utils.TreeNode;


public class SameTree {
  public static void main(String[] a) {
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);

    TreeNode root3 = new TreeNode(1);
    root3.left = new TreeNode(2);

    TreeNode root4 = new TreeNode(1);
    root4.left = null;
    root4.right = new TreeNode(2);

    System.out.println(isSameTree(root1,root2) ? "True" : "False");
    System.out.println(isSameTree(root3,root4) ? "True" : "False");


  }
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p==null && q==null) return true;
    if (p==null) return false;
    if (q==null) return false;
    return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
  }
}
