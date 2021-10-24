package com.company;

import java.util.ArrayList;
import java.util.List;

public class NarryTreePostOrderTraversalRecursive {

  public List<Integer> postorder(Node root) {

    return postorderTraversal(root, new ArrayList<>());

  }

  private List<Integer> postorderTraversal(Node root, List<Integer> result) {

    if(root == null) {
      return result;
    }

    for(Node node: root.children) {
      postorderTraversal(node, result);
    }

    result.add(root.val);

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
