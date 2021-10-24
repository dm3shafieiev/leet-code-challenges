package com.company;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addNumbers(l1, l2 , new ListNode(0), 0);
  }

  private ListNode addNumbers(ListNode l1, ListNode l2, ListNode result, int carry) {

    if(l1 == null && l2 == null) {
      if(carry == 1) {
        result.next = new ListNode(1);
      }
      return result;
    }

    int val1 = 0;
    int val2 = 0;

    if(l1 != null) {
      val1 = l1.val;
      l1 = l1.next;
    }

    if(l2 != null) {
      val2 = l2.val;
      l2 = l2.next;
    }

    int sum = val1 + val2 + carry;
    carry = sum/10;


    result.next = new ListNode(sum % 10);
    result = result.next;

    addNumbers(l1, l2, result, carry);

    return result;
  }

}
