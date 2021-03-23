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

    void addAtPos(int val, int pos) {
        Node temp = head;
        int count = 0;
        Node nn = new Node(val);
        if (pos == 0) {
            nn.next = temp;
            head = nn;
            return;
        }
        while (count < pos - 1) {
            count++;
            temp = temp.next;
        }
        nn.next = temp.next;
        temp.next = nn;
    }

    void deleteKey(int key) {
        if (head.data == key) {
            Node temp = head;
            head = head.next;
            temp = null;
            return;
        }
        Node temp = head;
        while (temp.next.data != key) {
            temp = temp.next;
        }
        Node delT = temp.next;
        temp.next = temp.next.next;
        delT.next = null;

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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(15);
        list.add(-56);
        list.add(1);
        list.add(100);
        list.add(-1008);
        list.add(598);
        list.add(696523);
        list.add(-23);
        list.printList();
        list.deleteKey(15);
        list.printList();
    }
}