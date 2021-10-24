package com.company;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_ToArrayList_And_Two_Pointers {

  /**
   * Input: head = [1,2,2,1]
   * Output: true
   */
  public boolean isPalindrome(ListNode head) {

    List<Integer> list = new ArrayList<>();
    list.add(head.val);

    while(head.next != null) {
      list.add(head.next.val);
      head = head.next;
    }

    for(int i = 0, k = list.size() - 1; i < k; i++, k--) {
      if(list.get(i).equals(list.get(k))) {
        return false;
      }
    }

    return true;

  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
