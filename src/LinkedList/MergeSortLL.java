package LinkedList;

public class MergeSortLL {
    private static Node findMiddle(Node head) {
        if (head == null)
            return head;
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node temp;
        if (left.data < right.data) {
            temp = left;
            temp.next = merge(left.next, right);
        } else {
            temp = right;
            temp.next = merge(left, right.next);
        }
        return temp;
    }

    private static Node mergeSort(Node head) {
        // no node or single node case
        if (head == null || head.next == null)
            return head;
        Node middle = findMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        return merge(left, right);
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
        list.head = mergeSort(list.head);
        System.out.println("After sorting :");
        list.printList();
    }
}