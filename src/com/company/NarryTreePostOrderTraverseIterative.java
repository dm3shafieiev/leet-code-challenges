package com.company;

import com.company.NarryTreePostOrderTraversalRecursive.Node;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NarryTreePostOrderTraverseIterative {

  public List<Integer> postorder(Node root) {

    LinkedList<Integer> result = new LinkedList<>();

    if(root == null) {
      return result;
    }


    Stack<Node> stack = new Stack<>();

    stack.push(root);

    while(!stack.isEmpty()) {

      Node currentParent = stack.pop();
      result.addFirst(currentParent.val);

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
  }

}
