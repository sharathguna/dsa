package code.utils;

import java.util.Arrays;
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

  public static void printTree(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        System.out.print(node.val + ",");
        queue.add(node.left);
        queue.add(node.right);
      } else {
        System.out.print("null,");
      }
    }
    System.out.println();
  }
  public static TreeNode constructTree(Integer[] array) {
     if (array.length == 0) return null;
     if (array.length == 1) return new TreeNode(array[0]);
     Queue<Integer> queue = new LinkedList<>(Arrays.asList(array));
     Queue<TreeNode> rootQueue = new LinkedList<>();
     TreeNode root = new TreeNode(queue.poll());
     rootQueue.add(root);
     while (!queue.isEmpty()) {
       TreeNode node = rootQueue.poll();
       if (queue.peek() != null) {
         node.left = new TreeNode(queue.poll());
       } else {
         queue.poll();
       }
       if (queue.peek() != null) {
         node.right = new TreeNode(queue.poll());
       } else {
         queue.poll();
       }
       rootQueue.add(node.left);
       rootQueue.add(node.right);
     }
     return root;
  }
}