package src.problems;

import src.problems.common.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        // 3 4 6 9 11
        ListNode head1 = new ListNode(3);
        head1.setNext(new ListNode(4)).setNext(new ListNode(6)).setNext(new ListNode(9)).setNext(new ListNode(11));
        ListNode.printList(head1);
        System.out.println(middleNode(head1).val);


        // 3 4 6 9 11 12
        ListNode head2 = new ListNode(3);
        head2.setNext(new ListNode(4)).setNext(new ListNode(6)).setNext(new ListNode(9)).setNext(new ListNode(11)).setNext(new ListNode(12));
        ListNode.printList(head2);
        System.out.println(middleNode(head2).val);

    }

    //Time Complexity: O(N), where N is the number of nodes in the given list.
    //
    //Space Complexity: O(1), the space used by slow and fast.
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}


