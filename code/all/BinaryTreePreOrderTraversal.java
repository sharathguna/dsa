package code.all;

import code.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class BinaryTreePreOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> values = preorderTraversal(root);
    for (int a: values) {
      System.out.println(a);
    }
  }
  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    getValues(root,values);
    return values;
  }
  static void getValues(TreeNode root,List<Integer> values) {
    if (root == null) {
      return;
    }
    values.add(root.val);
    getValues(root.left,values);
    getValues(root.right,values);
  }
}
