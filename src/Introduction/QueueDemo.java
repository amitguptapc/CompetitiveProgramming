import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(12);
        qu.add(21);
        qu.add(45);
        System.out.println(qu.poll());// similar to remove()
        System.out.println(qu.element());// similar to peek()
        System.out.println(qu.element());
    }
}
