package com.company;

import com.company.BinaryTreeLevelTraverse.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIterative {

  //TC: O(n) SC: O(N)
  public List<List<Integer>> levelOrder(TreeNode root) {

    LinkedList<List<Integer>> result = new LinkedList<>();

    if(root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while(!queue.isEmpty()) {

      result.add(new ArrayList<>());

      int levelSize = queue.size();

      for(int pointer = 0; pointer < levelSize; pointer++) {

        TreeNode elem =  queue.poll();

        result.getLast().add(elem.val);

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
