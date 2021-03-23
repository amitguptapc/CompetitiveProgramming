import java.io.*;
import java.util.StringTokenizer;

// https://www.hackerrank.com/challenges/cube-summation/problem
public class Structure3D {
    private static long[][][] arr;
    private static long[][][] BIT;

    private static long query(int x, int y, int z) {
        long ans = 0;
        for (int i = x; i > 0; i -= i & (-i))
            for (int j = y; j > 0; j -= j & (-j))
                for (int k = z; k > 0; k -= k & (-k))
                    ans += BIT[i][j][k];
        return ans;
    }

    private static void update(int x, int y, int z, long v) {
        long val = v - arr[x][y][z];
        arr[x][y][z] = v;
        for (int i = x; i <= 100; i += i & (-i))
            for (int j = y; j <= 100; j += j & (-j))
                for (int k = z; k <= 100; k += k & (-k))
                    BIT[i][j][k] += val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            arr = new long[101][101][101];
            BIT = new long[101][101][101];
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("UPDATE")) {
                    int x, y, z;
                    long w;
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    z = Integer.parseInt(st.nextToken());
                    w = Long.parseLong(st.nextToken());
                    update(x, y, z, w);
                } else {
                    int x1, y1, z1, x2, y2, z2;
                    x1 = Integer.parseInt(st.nextToken());
                    y1 = Integer.parseInt(st.nextToken());
                    z1 = Integer.parseInt(st.nextToken());
                    x2 = Integer.parseInt(st.nextToken());
                    y2 = Integer.parseInt(st.nextToken());
                    z2 = Integer.parseInt(st.nextToken());
                    long d = query(x2, y2, z2)
                            - query(x1 - 1, y2, z2) - query(x2, y1 - 1, z2) - query(x2, y2, z1 - 1)
                            + query(x1 - 1, y1 - 1, z2) + query(x1 - 1, y2, z1 - 1) + query(x2, y1 - 1, z1 - 1)
                            - query(x1 - 1, y1 - 1, z1 - 1);
                    bw.write(d + "\n");
                }
            }
        }
        bw.flush();
    }
}