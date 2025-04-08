package org.problems;

import org.problems.common.ListNode;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.setNext(new ListNode(2)).setNext(new ListNode(4));
        ListNode.printList(head1);

        ListNode head2 = new ListNode(1);
        head2.setNext(new ListNode(3)).setNext(new ListNode(4));
        ListNode.printList(head2);

        ListNode.printList(mergeTwoLists(head1, head2));
    }

    //Time complexity : O(n+m)
    //
    //Because exactly one of l1 and l2 is incremented on each loop
    //iteration, the while loop runs for a number of iterations equal to the
    //sum of the lengths of the two lists. All other work is constant, so the
    //overall complexity is linear.
    //
    //Space complexity : O(1)
    //
    //The iterative approach only allocates a few pointers, so it has a
    //constant overall memory footprint.
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = (list1 == null) ? list2 : list1;
        return preHead.next;
    }
}
