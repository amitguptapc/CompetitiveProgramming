package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

// https://atcoder.jp/contests/dp/tasks/dp_e
public class E_Knapsack2 {
    private static long getMaxValue(int[] weights, int[] values, int w, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (values[i - 1] <= j)
                    dp[i][j] = Math.min(
                            weights[i - 1] + dp[i - 1][j - values[i - 1]],
                            dp[i - 1][j]
                    );
                else dp[i][j] = dp[i - 1][j];
            }
        }

        int max = 0;
        for (int i = m; i >= 1; i--) {
            if (dp[n][i] <= w) {
                max = i;
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        int total_val = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
            total_val += values[i];
        }
        System.out.println(getMaxValue(weights, values, w, n, total_val));
    }
}
