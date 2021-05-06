package Dynamic_Programming.TwoDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {
    private static int[] wt, val;
    private static int[][] memo;

    // Pure DP
    private static int knapsack3(int n, int w) {
        /*
        dp[i][j] : max value with first i-1 elements when knapsack size is j
        */
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

    // Memoization
    private static int knapsack2(int n, int w) {
        if (n == 0 | w == 0)
            return 0;
        if (memo[n][w] != -1)
            return memo[n][w];
        if (wt[n - 1] <= w)
            return memo[n][w] = Math.max(
                    val[n - 1] + knapsack2(n - 1, w - wt[n - 1]),
                    knapsack2(n - 1, w)
            );
        else return memo[n][w] = knapsack2(n - 1, w);
    }

    // Naive
    private static int knapsack1(int n, int w) {
        if (n == 0 | w == 0)
            return 0;
        if (wt[n - 1] <= w)
            return Math.max(
                    val[n - 1] + knapsack1(n - 1, w - wt[n - 1]), // if nth object is included
                    knapsack1(n - 1, w) // if nth object is not included
            );
        else return knapsack1(n - 1, w);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        wt = new int[n];
        val = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();

        memo = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(memo[i], -1);

        System.out.println(knapsack3(n, w));
    }
}
