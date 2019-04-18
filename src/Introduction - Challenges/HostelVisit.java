import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class HostelVisit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());
        int dec, x, y;
        TreeSet<Long> pq = new TreeSet<>();
        while (q-- > 0) {
            str = new StringTokenizer(br.readLine());
            dec = Integer.parseInt(str.nextToken());
            if (dec == 1) {
                x = Integer.parseInt(str.nextToken());
                y = Integer.parseInt(str.nextToken());
                if (pq.size() == k) {
                    if (rocketDist(x, y) < pq.last()) {
                        pq.pollLast();
                        pq.add(rocketDist(x, y));
                    }
                } else {
                    pq.add(rocketDist(x, y));
                }
            } else
                System.out.println(pq.pollLast());
        }
    }

    private static long rocketDist(int x, int y) {
        return (x * x) + (y * y);
    }
}