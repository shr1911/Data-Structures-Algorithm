package src.problems;

import src.problems.common.ListNode;

public class RemoveDupSortedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.setNext(new ListNode(1)).setNext(new ListNode(2)).setNext(new ListNode(2)).setNext(new ListNode(2));
        ListNode.printList(head1);
        ListNode.printList(deleteDuplicates(head1));
    }

    //Time complexity : O(n). Because each node in the list is checked exactly once to determine if it is a duplicate or not, the total run time is O(n), where n is the number of nodes in the list.
    //
    //Space complexity : O(1). No additional space is used.
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next !=null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }
        return head;
    }
}
