package code.blind75;

import code.utils.ListNode;


public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Before Reversing : ");
    ListNode ptr = head;
    while (ptr != null) {
      System.out.print(ptr.val + "->");
      ptr = ptr.next;
    }
    System.out.print(";");
    System.out.println();
    ListNode reverseHead = reverseList(head);
    System.out.println("After Reversing : ");
    while (reverseHead != null) {
      System.out.print(reverseHead.val + "->");
      reverseHead = reverseHead.next;
    }
    System.out.print(";");
    System.out.println();
  }
  public static ListNode reverseList(ListNode head) {
    if (head == null) return null;
    ListNode prev = null;
    ListNode next;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
