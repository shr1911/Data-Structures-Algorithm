package src.ds;

public class DoublyLinkedList {
    Node head = null;

    public static void main(String[] args) {

        insertAtHeadTestCase();

        insertAtTailTestCase();

    }

    private static DoublyLinkedList insertAtTailTestCase() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtTail(2);
        doublyLinkedList.insertAtTail(3);
        doublyLinkedList.insertAtTail(4);

        doublyLinkedList.printList();

        return doublyLinkedList;
    }

    private static DoublyLinkedList insertAtHeadTestCase() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtHead(2);
        doublyLinkedList.insertAtHead(3);
        doublyLinkedList.insertAtHead(4);

        doublyLinkedList.printList();
        doublyLinkedList.reversePrintList();


        return doublyLinkedList;
    }

    public void insertAtHead(int data) {
        Node newNode = getNewNode(data);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        this.head.prev = newNode;
        newNode.next = this.head;
        this.head = newNode;
    }

    private Node getNewNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;
        newNode.next = null;

        return newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = getNewNode(data);
        Node temp = this.head;

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        // bring the pointer until end
        while (temp.next != null) {
            temp = temp.next;
        }

        newNode.prev = temp;
        temp.next = newNode;
    }

    public void printList() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reversePrintList() {
        Node temp = this.head;

        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

}

class Node {
    int data;
    Node prev;
    Node next;
}
