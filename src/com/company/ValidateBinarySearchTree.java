package com.company;

import com.company.BinaryTreeLevelTraverse.TreeNode;

public class ValidateBinarySearchTree {

  //TC: O(N) SC: O(N)
  private Integer prevValue;

  public boolean isValidBST(TreeNode root) {

    if(root == null) {
      return true;
    }

    if(!isValidBST(root.left)) {
      return false;
    }

    if (prevValue != null && root.val <= prevValue) {
      return false;
    }

    prevValue = root.val;

    return isValidBST(root.right);


  }


}
