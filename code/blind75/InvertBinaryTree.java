package code.blind75;

import code.blind75.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    System.out.println("Before Inverting : ");
    printTree(root);
    root = invertTree(root);
    System.out.println("After Inverting : ");
    printTree(root);
  }
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }
  static void printTree(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
      System.out.print(node.val + " , ");
    }
    System.out.println();
  }
}
