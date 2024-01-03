package code.all;

import code.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


public class MaximumWidthOfBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(9);
    System.out.println("The maximum width in the binary tree is : " + widthOfBinaryTree(root) );
  }
  public static int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(root,1));
    int maxWidth = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      int levelLength = queue.size();
      int left = queue.peek().getValue();
      int rootInt = left;
      while (levelLength-- > 0) {
        Pair<TreeNode, Integer> curr = queue.poll();
        TreeNode node = curr.getKey();
        rootInt = curr.getValue();
        if (node.left != null) queue.add(new Pair<>(node.left,rootInt*2));
        if (node.right != null) queue.add(new Pair<>(node.right,rootInt*2 + 1));
      }
      maxWidth = Math.max(maxWidth, rootInt - left + 1);
    }
    return maxWidth;
  }
  public static class Pair<T,S> {
    T t;
    S s;

    public Pair(T t, S s) {
      this.t = t;
      this.s = s;
    }

    public T getKey() {
      return t;
    }
    public S getValue() {
      return s;
    }
  }
}
