package LinkedList;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {
    Node head;

    void add(int d) {
        Node temp = new Node(d);
        temp.next = head;
        head = temp;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public LinkedList() {
        head = null;
    }
}