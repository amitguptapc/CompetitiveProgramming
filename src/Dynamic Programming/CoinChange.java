import java.util.Scanner;

public class CoinChange {
    private static int[] memo;

    // pure DP
    private static int minCoins3(int[] coins, int n, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int temp = dp[i - coins[j]];
                    if (temp != Integer.MAX_VALUE && temp + 1 < dp[i])
                        dp[i] = temp + 1;
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
        memo[amount] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                int temp = minCoins2(coins, n, amount - coins[i]);
                if (temp != Integer.MAX_VALUE && temp + 1 < memo[amount])
                    memo[amount] = temp + 1;
            }
        }
        return memo[amount];
    }

    // naive approach
    private static int minCoins1(int[] coins, int n, int amount) {
        if (amount == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                int temp = minCoins1(coins, n, amount - coins[i]);
                if (temp != Integer.MAX_VALUE && temp + 1 < ans)
                    ans = temp + 1;
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