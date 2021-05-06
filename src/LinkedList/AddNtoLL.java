package LinkedList;

import java.util.Scanner;

public class AddNtoLL {
    private static int carry = 0;

    private static void add15(Node root, int n) {
        if (root.next == null)
            root.data += n;
        if (root.next != null)
            add15(root.next, n);
        root.data += carry;
        carry = root.data / 10;
        root.data %= 10;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements : ");
        int a;
        while ((a = sc.nextInt()) > 0)
            list.add(a);
        System.out.println("Enter number to be added : ");
        int n = sc.nextInt();
        list.printList();
        add15(list.head, n);
        while (carry != 0) {
            Node temp = new Node(carry % 10);
            carry /= 10;
            temp.next = list.head;
            list.head = temp;
        }
        System.out.println("New number is : ");
        list.printList();
    }
}