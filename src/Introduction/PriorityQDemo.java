import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQDemo implements Comparator<Integer> {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new PriorityQDemo());
        pq.add(24);
        pq.add(2);
        pq.add(14);
        pq.add(5);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
        System.out.println(pq.comparator());
    }

    public int compare(Integer a, Integer b) {
        return a - b;
    }
}
