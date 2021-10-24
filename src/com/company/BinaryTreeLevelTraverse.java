package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreeNode;

public class BinaryTreeLevelTraverse {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if(root == null) return levels;

    return traverse(root, levels, 0);
  }

  public List<List<Integer>> traverse(TreeNode root, List<List<Integer>> levels, int level) {

    if(levels.size() == level)
      levels.add(new ArrayList<>());

    levels.get(level).add(root.val);


    if(root.left !=null ) {
      traverse(root.left, levels, level + 1);
    }

    if(root.right !=null ) {
      traverse(root.right, levels, level + 1);
    }

    return levels;
  }

 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}
