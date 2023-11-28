package code.blind75.utils;

import java.util.LinkedList;
import java.util.Queue;


public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   TreeNode() {}
   public TreeNode(int val) { this.val = val; }
   public TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }

  public void printTree(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        System.out.print(node.val + ",");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
    System.out.println();
  }
}