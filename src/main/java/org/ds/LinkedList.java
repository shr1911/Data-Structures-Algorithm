package org.ds;


public class LinkedList {
    // Pointer to head node
    DataNode head = null;
    public static void main(String[] args) {
        insertAtBeginningTestCase();

        insertAtNthPositionTestCase();
        
        deleteAtNthPoisitonTestCase();

        reverseLinkListTestCase();

        printLinkedListRecursivelyTestCase();
        
        reversePrintLinkedListRecursivelyTestCase();

        reverseLinkedListRecursivelyTestCase();

    }

    private static LinkedList reverseLinkedListRecursivelyTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        DataNode temp = linkedList.head;

        System.out.println("\n\nRecursive reverse linked list");
        linkedList.reverseLinkedListRecursively(temp);

        linkedList.printLinkedList();

        return linkedList;
    }

    private void reverseLinkedListRecursively(DataNode temp) {
        if (temp.next == null) {
            this.head = temp;
            return;
        }
        reverseLinkedListRecursively(temp.next);
        //next two lines can also mean - p.next.next = p;
        DataNode q = temp.next;
        q.next = temp;

        temp.next = null;

    }


    private static LinkedList reversePrintLinkedListRecursivelyTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        DataNode temp = linkedList.head;

        System.out.println("\n\nRecursive print reverse linked list");
        linkedList.reversePrintLinkedListRecursively(temp);

        return linkedList;
    }

    private void reversePrintLinkedListRecursively(DataNode temp) {
        if(temp == null){
            return;
        }
        reversePrintLinkedListRecursively(temp.next);
        System.out.print(temp.data + " ");

    }

    private static LinkedList printLinkedListRecursivelyTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        DataNode temp = linkedList.head;
        System.out.println("Recursively print linked list");

        linkedList.printLinkedListRecursively(temp);
        return linkedList;
    }

    private void printLinkedListRecursively(DataNode temp) {
        if(temp == null){
            return;
        }
        System.out.print(temp.data + " ");
        printLinkedListRecursively(temp.next);
    }


    private static LinkedList reverseLinkListTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        linkedList.reverseLinkedList();

        System.out.println("Reversing linked list in iterative way");
        linkedList.printLinkedList();
        return linkedList;
    }

    private void reverseLinkedList() {
        DataNode current = this.head;
        DataNode prev = null;
        DataNode nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        this.head = prev;
    }

    private static LinkedList deleteAtNthPoisitonTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        linkedList.deleteAtNthPosition(3);
        linkedList.deleteAtNthPosition(1);

        linkedList.printLinkedList();
        return linkedList;
    }

    private void deleteAtNthPosition(int position) {
        // Note deleted node will be garbage collected from memory
        DataNode temp = this.head;

        if (position == 1){
            this.head = temp.next;
            return;
        }

        for (int i=0; i < position-2; i++){
            temp = temp.next;
        }
        //nth node - temp2
        //n-1th node - temp
        DataNode temp2 = temp.next;
        temp.next = temp2.next;
    }

    private static LinkedList insertAtNthPositionTestCase() {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtNthPosition(2,1);
        linkedList.insertAtNthPosition(3,2);
        linkedList.insertAtNthPosition(4,1);
        linkedList.insertAtNthPosition(5,2);

        linkedList.printLinkedList();
        return linkedList;

    }

    private void insertAtNthPosition(int data, int position) {
        DataNode newNode = new DataNode(data, null);
        if (position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }
        DataNode temp = head;
        for(int i=0; i < position-2; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static LinkedList insertAtBeginningTestCase() {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBeginning(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtBeginning(4);
        linkedList.insertAtBeginning(5);
        linkedList.insertAtBeginning(6);
        linkedList.insertAtBeginning(7);

        linkedList.printLinkedList();
        return linkedList;
    }

    public void printLinkedList() {
        DataNode temp = this.head;
        System.out.println("List is : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public void insertAtBeginning(int x) {
        DataNode temp = new DataNode(x, null);
        temp.next = this.head;
        head = temp;
    }
}

class DataNode {
    int data;
    DataNode next;

    public DataNode(int data, DataNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}