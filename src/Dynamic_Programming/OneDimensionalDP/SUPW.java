package Dynamic_Programming.OneDimensionalDP;

import java.io.*;
import java.util.StringTokenizer;

// https://www.codechef.com/ZCOPRAC/problems/ZCO14002
public class SUPW {
    private static long minTime(long[] a, int n) {
        long[] dp = new long[n];
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];
        for (int i = 3; i < n; i++)
            dp[i] = a[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        return Math.min(dp[n - 1], Math.min(dp[n - 2], dp[n - 3]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(st.nextToken());
        bw.write(minTime(a, n) + "\n");
        bw.flush();
    }
}
