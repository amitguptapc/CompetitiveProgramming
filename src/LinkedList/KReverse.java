package LinkedList;

public class KReverse {
    private static Node reverse(Node head, int k) {
        Node curr = head, pre = null, next = null;
        int c = 0;
        while (curr != null && c < k) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            c++;
        }
        if (next != null)
            head.next = reverse(next, k);
        return pre;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 10; i++)
            list.add(i);
        list.printList();
        list.head = reverse(list.head, 2);
        list.printList();
    }
}