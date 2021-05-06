package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class MinCoinChange {
    private static int[] memo;
    private static final int INF = 1000000;

    // pure DP
    private static int minCoins3(int[] coins, int n, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int temp = dp[i - coins[j]];
                    dp[i] = Math.min(dp[i], temp + 1);
                }
            }
        }
        return dp[amount];
    }

    // memoization
    private static int minCoins2(int[] coins, int n, int amount) {
        if (memo[amount] != -1)
            return memo[amount];
        if (amount == 0)
            return 0;
        memo[amount] = INF;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                int temp = minCoins2(coins, n, amount - coins[i]);
                memo[amount] = Math.min(temp + 1, memo[amount]);
            }
        }
        return memo[amount];
    }

    // naive approach
    private static int minCoins1(int[] coins, int n, int amount) {
        if (amount == 0)
            return 0;
        int ans = INF;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                int temp = minCoins1(coins, n, amount - coins[i]);
                ans = Math.min(temp + 1, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        memo = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            memo[i] = -1;
        System.out.println(minCoins3(coins, n, amount));
    }
}