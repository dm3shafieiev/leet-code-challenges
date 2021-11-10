package com.company;

import com.company.BinaryTreeLevelTraverse.TreeNode;

public class SymmetricTree {


  //TC: O(N) SC: O(N)
  public boolean isSymmetric(TreeNode root) {

    return isSymmetricFunc(root.left, root.right);

  }

  public boolean isSymmetricFunc(TreeNode root1, TreeNode root2) {

    if(root1 == null && root2 == null) {
      return true;
    }

    if(root1 == null || root2 == null) {
      return false;
    }

    return (root1.val == root2.val) && isSymmetricFunc(root1.left, root2.right)
        && isSymmetricFunc(root1.right, root2.left);
  }

}
