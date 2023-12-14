package code.blind75;

import code.utils.ListNode;


public class MergeTwoSortedList {
  public static void main(String[] args) {
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(4);
    head1.next.next.next = null;

    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(4);
    head2.next.next.next = null;

    ListNode mergedHead = mergeTwoLists(head1, head2);
    while (mergedHead != null) {
      System.out.print(mergedHead.val + " -> ");
      mergedHead = mergedHead.next;
    }
  }
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      if (list1 != null) {
        return list1;
      }
      if (list2 != null) {
        return list2;
      }
    }
    ListNode result = new ListNode();
    ListNode ptr = result;

    while (list1 != null && list2 != null) {
      if ( list1.val < list2.val) {
        ptr.next = new ListNode(list1.val);
        list1 = list1.next;
      }
      else {
        ptr.next = new ListNode(list2.val);
        list2 = list2.next;
      }
      ptr = ptr.next;
    }
    if (list1 != null) {
      ptr.next = list1;
    } else if (list2 != null) {
      ptr.next = list2;
    }
    return result.next;
  }
}
