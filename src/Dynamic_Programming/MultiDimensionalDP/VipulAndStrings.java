package Dynamic_Programming.MultiDimensionalDP;

import java.io.*;
import java.util.StringTokenizer;

public class VipulAndStrings {
    private static int n, m, k;
    private static char[] s, t;
    private static int[][][][] dp;

    private static int solve(int is, int it, int rem, int cont) {
        if (is == n || it == m || rem == 0)
            return 0;
        if (dp[is][it][rem][cont] != -1)
            return dp[is][it][rem][cont];
        int ans = Math.max(solve(is + 1, it, rem - cont, 0),
                solve(is, it + 1, rem - cont, 0));
        if (s[is] == t[it])
            ans = Math.max(ans, 1 + solve(is + 1, it + 1, rem, 1));
        return dp[is][it][rem][cont] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = br.readLine().toCharArray();
        t = br.readLine().toCharArray();

        dp = new int[n + 1][m + 1][k + 1][2];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                for (int l = 0; l <= k; l++)
                    dp[i][j][l][0] = dp[i][j][l][1] = -1;

        bw.write(solve(0, 0, k, 0) + "\n");
        bw.flush();
    }
}
