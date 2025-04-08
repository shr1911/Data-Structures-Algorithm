package org.problems;

import org.problems.common.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // 3 4 6 9 11
        ListNode head1 = new ListNode(3);
        head1.setNext(new ListNode(4)).setNext(new ListNode(6)).setNext(new ListNode(9)).setNext(new ListNode(11));
        ListNode.printList(head1);

        ListNode reversedList = reverseList(head1);
        ListNode.printList(reversedList);

        // ToDo: Understand and go through recursive linked list
    }

    //Time complexity : O(n).
    //Assume that n is the list's length, the time complexity is O(n).
    //
    //Space complexity : O(1).
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
