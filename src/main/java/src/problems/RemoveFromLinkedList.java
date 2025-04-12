package src.problems;

import src.problems.common.ListNode;

public class RemoveFromLinkedList {
    public static void main(String[] args) {
        // 3 4 6 9 11
        ListNode head1 = new ListNode(3);
        head1.setNext(new ListNode(4)).setNext(new ListNode(6)).setNext(new ListNode(4)).setNext(new ListNode(11));
        ListNode.printList(head1);

        ListNode newHead1 = removeElements(head1, 4);
        ListNode.printList(newHead1);

    }

    //Time complexity: O(N), it's one pass solution.
    //
    //Space complexity: O(1), it's a constant space solution.
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
