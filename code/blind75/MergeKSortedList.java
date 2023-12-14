package code.blind75;

import code.utils.ListNode;
import java.util.PriorityQueue;


public class MergeKSortedList {
  public static void main(String[] args) {

    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(7);
    list1.next.next = new ListNode(10);
    list1.next.next.next = null;

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);
    list2.next.next.next = null;

    ListNode list3 = new ListNode(2);
    list3.next = new ListNode(6);
    list3.next.next = null;

    ListNode[] listNodes = {list1, list2, list3};
    System.out.println("The linked list after sorting all the lists are : ");
    ListNode mergedHead = mergeKLists(listNodes);
    while (mergedHead != null) {
      System.out.println(mergedHead.val + " -> ");
      mergedHead = mergedHead.next;
    }
  }
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;

    ListNode result = new ListNode();
    ListNode head = result;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (ListNode list : lists) {
      while (list != null) {
        minHeap.add(list.val);
        list = list.next;
      }
    }
    while (!minHeap.isEmpty()) {
      int element = minHeap.poll();
      result.next = new ListNode(element);
      result = result.next;
    }
    return head.next;
  }
}
