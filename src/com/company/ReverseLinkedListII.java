package com.company;

public class ReverseLinkedListII {

  //TC: O(N) SC: O(1)
  public ListNode reverseBetween(ListNode head, int left, int right) {

    int counter = 1;
    ListNode lastNodeBeforeList = null;
    ListNode current = head;

    while(counter < left && head.next != null) {

      lastNodeBeforeList = current;
      current = current.next;

      counter++;
    }

    ListNode prev = null;

    while(counter != (right + 1)) {

      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      counter++;
    }

    if(lastNodeBeforeList != null) {
      lastNodeBeforeList.next = prev;
    } else {
      head = prev;
    }



    return head;
  }

}
