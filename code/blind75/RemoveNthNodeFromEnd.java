package code.blind75;

public class RemoveNthNodeFromEnd {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = null;
    ListNode temp = head;
    do {
      System.out.print(temp.val + " ->");
      temp = temp.next;
    } while ( temp != null);
    System.out.println();
    temp = removeNthFromEnd(head,5);
    do {
      assert temp != null;
      System.out.print(temp.val + " ->");
      temp = temp.next;
    } while ( temp != null);
  }
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null) return null;
    ListNode headPtr = head;
    ListNode movePtr = head;
    int i = 0;
    while (i<n-1) {
      movePtr = movePtr.next;
      i++;
    }
    if (movePtr.next == null) return headPtr.next;
    ListNode previous = headPtr;
    while (movePtr.next != null) {
      previous = headPtr;
      movePtr = movePtr.next;
      headPtr = headPtr.next;
    }
    previous.next = headPtr.next;

    return head;
  }
}
