package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

// https://www.codechef.com/submit/MIXTURES
// application of matrix chain multiplication

public class Mixtures {
    private static long[][] dp;
    private static int[] a;

    private static long sum(int i, int j) {
        long ans = 0;
        for (int k = i; k <= j; k++)
            ans = (ans + a[k]) % 100;
        return ans;
    }

    private static long minSmoke(int i, int j) {
        if (i >= j) // base case
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], minSmoke(i, k) + minSmoke(k + 1, j) + sum(i, k) * sum(k + 1, j));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            dp = new long[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dp[i][j] = -1;
            System.out.println(minSmoke(0, n - 1));
        }
    }
}