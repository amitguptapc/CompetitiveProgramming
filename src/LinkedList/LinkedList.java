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
    Node head, ptr;

    public LinkedList() {
        head = null;
        ptr = null;
    }

    void add(int d) {
        Node temp = new Node(d);
        if (head == null) {
            ptr = temp;
            head = ptr;
        } else {
            ptr.next = temp;
            ptr = ptr.next;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}