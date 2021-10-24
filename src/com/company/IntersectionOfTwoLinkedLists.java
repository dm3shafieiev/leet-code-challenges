package com.company;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> nodesInB = new HashSet<>();

    while (headB != null) {
      nodesInB.add(headB);
      headB = headB.next;
    }

    while (headA != null) {
      // if we find the node pointed to by headA,
      // in our set containing nodes of B, then return the node
      if (nodesInB.contains(headA)) {
        return headA;
      }
      headA = headA.next;
    }

    return null;


  }
//TC: O(n+m)  SC: O(m)

}
