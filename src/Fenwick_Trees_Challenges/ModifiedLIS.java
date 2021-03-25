import java.io.*;
import java.util.*;

public class ModifiedLIS {
    private static final int max = 200000;
    private static long[] BIT;

    private static long query(int a) {
        long ans = 0;
        while (a > 0) {
            ans = Math.max(ans, BIT[a]);
            a -= a & (-a);
        }
        return ans;
    }

    private static void update(int a, long v) {
        while (a <= max) {
            BIT[a] = Math.max(BIT[a], v);
            a += a & (-a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            long[] w = new long[n];
            st = new StringTokenizer(br.readLine());
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                set.add(a[i]);
            }
            int i = 1;
            HashMap<Long, Integer> map = new HashMap<>();
            for (long l : set)
                map.put(l, i++);
            st = new StringTokenizer(br.readLine());
            for (i = 0; i < n; i++)
                w[i] = Long.parseLong(st.nextToken());
            BIT = new long[max + 1];
            for (i = 0; i < n; i++) {
                long prevMax = query(map.get(a[i]) - 1);
                update(map.get(a[i]), prevMax + w[i]);
            }
            bw.write(query(max) + "\n");
        }
        bw.flush();
    }
}