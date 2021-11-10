package com.company;

import com.company.BinaryTreeLevelTraverse.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

  //TC: O(N) SC: O(N)
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    LinkedList<List<Integer>> result = new LinkedList<>();

    if(root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {

      LinkedList<Integer> levelList = new LinkedList<>();
      result.add(levelList);

      int levelSize = queue.size();

      for(int pointer = 0; pointer < levelSize; pointer++) {

        TreeNode elem =  queue.poll();

        if(result.size() % 2 == 0) {
          levelList.addFirst(elem.val);
        } else {
          levelList.add(elem.val) ;
        }

        if(elem.left != null) {
          queue.add(elem.left);
        }

        if(elem.right != null) {
          queue.add(elem.right);
        }

      }

    }

    return result;
  }

}
