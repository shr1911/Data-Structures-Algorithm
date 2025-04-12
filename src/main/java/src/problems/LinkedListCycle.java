package src.problems;


import src.problems.common.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode cycleNode = new ListNode(2);
        ListNode list1 = new ListNode(3);
        list1.setNext(cycleNode).setNext(new ListNode(0)).setNext(new ListNode(-4)).setNext(cycleNode);
        System.out.println(hasCycle(list1));

        ListNode list2 = new ListNode(3);
        list2.setNext(new ListNode(0)).setNext(new ListNode(-4));
        System.out.println(hasCycle(list2));
    }

    //Time complexity : O(n).
    //Let us denote n as the total number of nodes in the linked list. To
    //List has no cycle:
    //The fast pointer reaches the end first and the run time depends on the list's length, which is O(n).
    //List has a cycle:
    //We break down the movement of the slow pointer into two steps, the non-cyclic part and the cyclic part:
    //
    //The slow pointer takes "non-cyclic length" steps to enter the cycle. At this point, the fast pointer has already reached the cycle. Number of iterations=non-cyclic length=N
    //
    //Both pointers are now in the cycle. Consider two runners running in a cycle - the fast runner moves 2 steps while the slow runner moves 1 steps at a time. Since the speed difference is 1, it takes
    //difference of speed
    //distance between the 2 runners
    //​
    //  loops for the fast runner to catch up with the slow runner.As the distance is at most cyclic length K - 1 and the speed difference is 1, we conclude that
    //Number of iterations=at most cyclic length K - 1.
    //
    //Therefore, the worst case time complexity is O(N+K), which is O(n).

    //Space complexity : O(1).
    //We only use two nodes (slow and fast) so the space complexity is O(1).
    public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}


