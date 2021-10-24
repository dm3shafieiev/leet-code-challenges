package com.company;

public class TwoLinkedListsIntersectionNAIVE {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    int sizeA = 0;
    int sizeB = 0;
    int diff = 0;

    ListNode copyA = headA;
    ListNode copyB = headB;

    while(copyA != null) {
      copyA = copyA.next;
      sizeA ++;
    }

    while(copyB != null) {
      copyB = copyB.next;
      sizeB ++;
    }

    if(sizeA > sizeB) {
      diff = sizeA - sizeB;
      return findIntersection(diff, headB, headA);
    }else {
      diff = sizeB - sizeA;
      return findIntersection(diff, headA, headB);

    }

  }

  private ListNode findIntersection(int diff, ListNode headA, ListNode headB) {

    ListNode auxA = headA;
    ListNode auxB = headB;

    while(auxB != null) {
      if(diff > 0) {
        auxB = auxB.next;
        diff--;
      } else {
        if(auxB == auxA) {
          return auxB;
        }else {
          auxA = auxA.next;
          auxB = auxB.next;
        }
      }
    }
    return null;
  }

  //TC: O(n+m) SC: O(1)

}
