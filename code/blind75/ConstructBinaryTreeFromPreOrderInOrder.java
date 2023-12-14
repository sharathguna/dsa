package code.blind75;

import code.utils.TreeNode;
import java.util.Arrays;


public class ConstructBinaryTreeFromPreOrderInOrder {
  public static void main(String[] args){
    int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
    TreeNode root = buildTree(preorder, inorder);
    root.printTree(root);
  }
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0 ) return null;
    int rootVal = preorder[0];
    TreeNode root = new TreeNode(rootVal);
    if (preorder.length == 1) {
      return root;
    }
    int mid = getRootIndex(inorder,rootVal);
    root.left = buildTree(Arrays.copyOfRange(preorder,1,mid+1),Arrays.copyOfRange(inorder,0,mid));
    root.right = buildTree(Arrays.copyOfRange(preorder,mid+1,preorder.length),Arrays.copyOfRange(inorder,mid+1,inorder.length));
    return root;
  }

  static int getRootIndex(int[] inorder, int rootVal) {
    for(int i =0; i < inorder.length; i++) {
      if (inorder[i] == rootVal) {
        return i;
      }
    }
    return -1;
  }
}
