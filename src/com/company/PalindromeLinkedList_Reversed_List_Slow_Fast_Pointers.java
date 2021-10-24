package com.company;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_Reversed_List_Slow_Fast_Pointers {

  /**
   * Input: head = [1,2,2,1]
   * Output: true
   */
  public boolean isPalindrome(ListNode head) {
    if(head == null) return true;

    ListNode endOfFirstHalf = findEndOfFirstHalf(head);
    ListNode reversedSecondHalfStart = reverseList(endOfFirstHalf.next);

    ListNode pointer1 = head;
    ListNode pointer2 = reversedSecondHalfStart;

    while(pointer2 != null) {

      if(pointer1.val != pointer2.val) {
        return false;
      }

      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return true;
  }

  private ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode prev = null;

    while( current != null ) {
      ListNode currentNext = current.next;
      current.next = prev;
      prev = current;
      current = currentNext;
    }

    return prev;

  }

  private ListNode findEndOfFirstHalf(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
