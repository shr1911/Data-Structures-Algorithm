package src.ds;

/**
 * O(1) for all operation is the definition of stack. hence insert and delete at top of linked list
 */

public class StackUsingLinkedList {

    StackNode top = null;
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(2);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.print();
    }

    private void pop() {
        if (top == null) {
            System.out.println("Error: stack is empty");
            return;
        }
        top = top.next;
    }

    private void print() {
        StackNode temp = this.top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void push(int data){
        StackNode newNode = getNewNode(data);
        newNode.next = this.top;
        this.top = newNode;
    }

    private StackNode getNewNode(int data) {
        StackNode stackNode = new StackNode();
        stackNode.data = data;
        stackNode.next = null;
        return stackNode;
    }
}


class StackNode {
    int data;
    StackNode next;
}

