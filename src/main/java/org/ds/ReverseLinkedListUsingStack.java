package org.ds;

import java.util.Stack;

/**
 * time complexity - O(n) for accessing
 */
public class ReverseLinkedListUsingStack {
    public static void main(String[] args) {
        LinkedList list = LinkedList.insertAtBeginningTestCase();

        Stack<DataNode> stack = new Stack<>();
        DataNode temp = list.head;

        // Push all references
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = stack.pop();
        list.head = temp;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;

        list.printLinkedList();

    }


}
