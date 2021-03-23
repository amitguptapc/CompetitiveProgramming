import java.io.*;
import java.util.*;

// https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/buy-and-sell/
public class BuyAndSell {
    private static int max = 100000;
    private static long[] BIT;

    private static long query(int a) {
        long ans = 0;
        while (a > 0) {
            ans += BIT[a];
            a -= a & (-a);
        }
        return ans;
    }

    private static void update(int i, long v) {
        while (i <= max) {
            BIT[i] += v;
            i += i & (-i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        BIT = new long[max + 1];
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> price = new HashMap<>();
        HashMap<String, Integer> qty = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            int pr = Integer.parseInt(st.nextToken());
            price.put(item, pr);
            qty.put(item, 0);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            if (type == '+') {
                String item = st.nextToken();
                qty.put(item, qty.get(item) + 1);
                update(price.get(item), 1);
            } else if (type == '-') {
                String item = st.nextToken();
                if (qty.get(item) > 0) {
                    update(price.get(item), -1);
                    qty.put(item, qty.get(item) - 1);
                }
            } else {
                int p = Integer.parseInt(st.nextToken());
                bw.write((query(max) - query(p)) + "\n");
            }
        }
        bw.flush();
    }
}