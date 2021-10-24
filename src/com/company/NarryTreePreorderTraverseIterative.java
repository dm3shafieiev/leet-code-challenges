package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NarryTreePreorderTraverseIterative {

  public List<Integer> preorder(Node root) {
    if(root == null) {
      return Collections.EMPTY_LIST;
    }

    LinkedList<Integer> result = new LinkedList<>();
    Stack<Node> stack = new Stack();

    stack.push(root);

    while(!stack.isEmpty()) {

      Node currentParent = stack.pop();
      result.add(currentParent.val);

      Collections.reverse(currentParent.children);
      for(Node child: currentParent.children)  {

        stack.push(child);
      }

    }

    return result;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

}
