package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {


  //TC: O(n) SC: O(n)
  public Node connect(Node root) {

    if(root == null) {
      return root;
    }

    Queue<Node> queue = new LinkedList();

    queue.add(root);

    while(!queue.isEmpty()) {

      int levelSize = queue.size();

      for(int pointer = 0; pointer < levelSize; pointer++) {

        Node node = queue.poll();

        if(pointer < levelSize - 1) {
          node.next = queue.peek();
        }

        if(node.left != null ) {
          queue.add(node.left);
        }

        if(node.right != null ) {
          queue.add(node.right);
        }


      }

    }

    return root;

  }

  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
}
