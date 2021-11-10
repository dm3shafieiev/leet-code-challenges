package com.company;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

  //TC: O(n) SC: O(n)
  public Node copyRandomList(Node head) {

    return copyList(head, new HashMap<Node,Node>());

  }

  public Node copyList(Node head, Map<Node, Node> visitedNodes) {

    if(head == null) {
      return null;
    }

    if (visitedNodes.containsKey(head)) {
      return visitedNodes.get(head);
    }

    Node copy = new Node(head.val);

    visitedNodes.put(head, copy);

    copy.next = copyList(head.next, visitedNodes);
    copy.random = copyList(head.random, visitedNodes);

    return copy;
  }

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

}
