package Dynamic_Programming.OneDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
    private static int[] memo;

    // Pure DP
    private static int maxProfit3(int[] price, int totalLen) {
        int[] dp = new int[totalLen + 1];
        for (int len = 1; len <= totalLen; len++) {
            int max = 0;
            for (int cut = 1; cut <= len; cut++) {
                max = Math.max(max, price[cut] + dp[len - cut]);
            }
            dp[len] = max;
        }
        return dp[totalLen];
    }

    // Memoization
    private static int maxProfit2(int[] price, int totalLen) {
        if (totalLen == 0)
            return 0;
        if (memo[totalLen] != -1)
            return memo[totalLen];
        int max = 0, profit;
        for (int len = 1; len <= totalLen; len++) {
            profit = price[len] + maxProfit2(price, totalLen - len);
            max = Math.max(profit, max);
        }
        memo[totalLen] = max;
        return memo[totalLen];
    }

    // Naive
    private static int maxProfit1(int[] price, int totalLen) {
        if (totalLen == 0)
            return 0;
        int max = 0, profit;
        for (int len = 1; len <= totalLen; len++) {
            profit = price[len] + maxProfit1(price, totalLen - len);
            max = Math.max(profit, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        System.out.println(maxProfit3(a, n));
    }
}