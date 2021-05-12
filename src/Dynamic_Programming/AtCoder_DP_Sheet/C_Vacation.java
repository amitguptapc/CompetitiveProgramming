package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

// https://atcoder.jp/contests/dp/tasks/dp_c
public class C_Vacation {
    private static long getMax(long[][] a, int n) {
        long[][] dp = new long[n][3];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = a[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = a[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = a[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] a = new long[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = sc.nextLong();
        System.out.println(getMax(a, n));
    }
}
