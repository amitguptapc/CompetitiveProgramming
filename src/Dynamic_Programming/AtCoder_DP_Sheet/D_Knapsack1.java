package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

// https://atcoder.jp/contests/dp/tasks/dp_d
public class D_Knapsack1 {
    private static long getMaxValue(int[] weights, long[] values, int w, int n) {
        long[][] dp = new long[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weights[i - 1] <= j)
                    dp[i][j] = Math.max(
                            values[i - 1] + dp[i - 1][j - weights[i - 1]],
                            dp[i - 1][j]
                    );
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] weights = new int[n];
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextLong();
        }
        System.out.println(getMaxValue(weights, values, w, n));
    }
}
