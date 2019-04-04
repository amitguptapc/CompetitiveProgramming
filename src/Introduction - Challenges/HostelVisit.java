import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HostelVisit implements Comparator<Long> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int k = sc.nextInt();
        int dec, x, y;
        PriorityQueue<Long> pq = new PriorityQueue<>(new HostelVisit());
        while (q > 0) {
            dec = sc.nextInt();
            if (dec == 1) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (pq.size() == k) {
                    if (rocketDist(x, y) < pq.peek()) {
                        pq.poll();
                        pq.add(rocketDist(x, y));
                    }
                } else {
                    pq.add(rocketDist(x, y));
                }
            } else
                System.out.println(pq.peek());
            q--;
        }
    }

    private static long rocketDist(int x, int y) {
        return (x * x) + (y * y);
    }

    @Override
    public int compare(Long o1, Long o2) {
        if (o1 > o2)
            return -1;
        else if (o1 < o2)
            return 1;
        else return 0;
    }
}