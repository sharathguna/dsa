package code.blind75;

import code.blind75.utils.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode tree1 = new TreeNode(1);
    tree1.left = new TreeNode(2);
    tree1.right = new TreeNode(3);
    tree1.left.left = new TreeNode(4);
    tree1.left.right = null;
    tree1.right.left = null;
    tree1.right.right = new TreeNode(5);

    TreeNode tree2 = new TreeNode(1);

    TreeNode tree3 = null;

    System.out.println(levelOrder(tree1).toString());
    System.out.println(levelOrder(tree2).toString());
    System.out.println(levelOrder(tree3).toString());
  }
  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int len = queue.size();
      List<Integer> numberList = new ArrayList<>();
      while (len-->0) {
        TreeNode node = queue.poll();
        if (node != null) {
          numberList.add(node.val);
          if (node.left != null) queue.add(node.left);
          if (node.right != null) queue.add(node.right);
        }
      }
      result.add(numberList);
    }
    return result;
  }
}
