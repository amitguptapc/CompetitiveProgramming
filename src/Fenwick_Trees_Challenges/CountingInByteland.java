import java.io.*;
import java.util.StringTokenizer;

// https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/counting-in-byteland/
public class CountingInByteland {
    private static long[][][] BIT;

    private static long query(int x, int y, int z) {
        long ans = 0;
        for (int i = x; i > 0; i -= i & (-i))
            for (int j = y; j > 0; j -= j & (-j))
                for (int k = z; k > 0; k -= k & (-k))
                    ans += BIT[i][j][k];
        return ans;
    }

    private static void update(int x, int y, int z, long val) {
        for (int i = x; i <= 101; i += i & (-i))
            for (int j = y; j <= 101; j += j & (-j))
                for (int k = z; k <= 101; k += k & (-k))
                    BIT[i][j][k] += val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BIT = new long[102][102][102];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long all = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int x, y, z;
                long w;
                x = Integer.parseInt(st.nextToken()) + 1;
                y = Integer.parseInt(st.nextToken()) + 1;
                z = Integer.parseInt(st.nextToken()) + 1;
                w = Long.parseLong(st.nextToken());
                all += w;
                update(x, y, z, w);
            } else {
                int x1, y1, z1, x2, y2, z2;
                x1 = Integer.parseInt(st.nextToken()) + 1;
                y1 = Integer.parseInt(st.nextToken()) + 1;
                z1 = Integer.parseInt(st.nextToken()) + 1;
                x2 = Integer.parseInt(st.nextToken()) + 1;
                y2 = Integer.parseInt(st.nextToken()) + 1;
                z2 = Integer.parseInt(st.nextToken()) + 1;
                long d = query(x2, y2, z2)
                        - query(x1 - 1, y2, z2) - query(x2, y1 - 1, z2) - query(x2, y2, z1 - 1)
                        + query(x1 - 1, y1 - 1, z2) + query(x1 - 1, y2, z1 - 1) + query(x2, y1 - 1, z1 - 1)
                        - query(x1 - 1, y1 - 1, z1 - 1);
                bw.write((all - d) + "\n");
            }
        }
        bw.flush();
    }
}