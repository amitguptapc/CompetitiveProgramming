package Mathematics;

// https://codeforces.com/problemset/problem/846/F

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RandomQuery {
    private static int n;
    private static int[] a;

    private static long func() {
        int[] pos = new int[1000001];
        long[] dp = new long[n];
        dp[0] = 1;
        pos[a[0]] = 1;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (i - pos[a[i]]);
            ans += dp[i];
            pos[a[i]] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(str.nextToken());
        double ans = (2 * func() - n) / (n * n * 1.0);
        System.out.println(ans);
    }
}
