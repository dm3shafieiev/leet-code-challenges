package com.company;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {


  //TC: O(n) SC: O(n)
  public ListNode detectCycle(ListNode head) {
    if(head == null) {
      return null;
    }

    Set<ListNode> set = new HashSet<>();
    ListNode cursor = head;

    while(!set.contains(cursor)) {
      if(cursor.next == null) {
        return null;
      }
      set.add(cursor);
      cursor = cursor.next;
    }

    return cursor;
  }

}
