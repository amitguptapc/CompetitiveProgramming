package LinkedList;

public class QuickSortLL {
    private static Node quickSort(Node head) {
        if (head == null || head.next == null)
            return head;
        return null;
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
        list.head = quickSort(list.head);
        System.out.println("After sorting :");
        list.printList();
    }
}