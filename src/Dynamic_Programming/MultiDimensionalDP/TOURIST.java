package MultidimensionalDP;

import java.io.*;
import java.util.StringTokenizer;

// https://www.spoj.com/problems/TOURIST/
public class TOURIST {
    private static long[][][] dp;
    private static char[][] a;
    private static int m, n;

    private static long solve(int x1, int y1, int x2, int y2) {
        if (x1 >= m || y1 >= n || x2 >= m || y2 >= n || a[x1][y1] == '#' || a[x2][y2] == '#')
            return Integer.MIN_VALUE;
        if (x1 == m - 1 && y1 == n - 1)
            return a[x1][y1] == '*' ? 1 : 0;
        if (dp[x1][y1][x2] != -1)
            return dp[x1][y1][x2];
        long ans = Integer.MIN_VALUE;
        ans = Math.max(ans, solve(x1 + 1, y1, x2 + 1, y2));
        ans = Math.max(ans, solve(x1 + 1, y1, x2, y2 + 1));
        ans = Math.max(ans, solve(x1, y1 + 1, x2 + 1, y2));
        ans = Math.max(ans, solve(x1, y1 + 1, x2, y2 + 1));
        ans += a[x1][y1] == '*' ? 1 : 0;
        ans += a[x2][y2] == '*' ? 1 : 0;
        if (x1 == x2 && y1 == y2 && a[x1][y1] == '*')
            ans--;
        return dp[x1][y1][x2] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new char[m][n];
            for (int i = 0; i < m; i++)
                a[i] = br.readLine().toCharArray();
            dp = new long[m][n][m];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < m; k++)
                        dp[i][j][k] = -1;
            bw.write(solve(0, 0, 0, 0) + "\n");
        }
        bw.flush();
    }
}