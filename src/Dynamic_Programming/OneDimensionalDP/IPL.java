package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// https://www.codechef.com/ZCOPRAC/problems/ZCO14004
public class IPL {
    private static long minTime(long[] a, int n) {
        long[] dp = new long[n];
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];
        for (int i = 3; i < n; i++)
            dp[i] = a[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        return Math.min(dp[n - 1], Math.min(dp[n - 2], dp[n - 3]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            ans += a[i];
        }
        System.out.println(ans - minTime(a, n));
    }
}
