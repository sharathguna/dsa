package code.neetcode;

import code.utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideView {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    for(int a : rightSideView(root)) {
      System.out.println(a);
    }
  }
  public static List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> resultList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      while(levelSize-- > 1) {
        TreeNode temp = queue.poll();
        if (temp.left != null) queue.add(temp.left);
        if (temp.right != null) queue.add(temp.right);
      }
      TreeNode rightMostNode = queue.poll();
      resultList.add(rightMostNode.val);
      if (rightMostNode.left != null) queue.add(rightMostNode.left);
      if (rightMostNode.right != null) queue.add(rightMostNode.right);
    }
    return resultList;
  }
}
