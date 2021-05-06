package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class LCS {
    private static int[][] memo;
    private static char[] r, s;
    private static int n, m;

    // Pure DP
    private static int lcs3() {
        /*
        dp[i][j] : length of LCS for strings R[0..i-1] and S[0...j-1]
        */
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (r[i - 1] == s[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Memoization
    private static int lcs2(int i, int j) {
        if (i == m || j == n)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (r[i] == s[j])
            return memo[i][j] = 1 + lcs1(i + 1, j + 1);
        return memo[i][j] = Math.max(lcs1(i + 1, j), lcs1(i, j + 1));
    }

    // Naive
    private static int lcs1(int i, int j) {
        if (i == m || j == n)
            return 0;
        if (r[i] == s[j])
            return 1 + lcs1(i + 1, j + 1);
        return Math.max(lcs1(i + 1, j), lcs1(i, j + 1));
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        r = sc.next().toCharArray();
        s = sc.next().toCharArray();
        m = r.length;
        n = s.length;
        memo = new int[m][n];
        for (int i = 0; i < m * n; i++)
            memo[i / n][i % n] = -1;
        System.out.println(lcs3());
    }
}