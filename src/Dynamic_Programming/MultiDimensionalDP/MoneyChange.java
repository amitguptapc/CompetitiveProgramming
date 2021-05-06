package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class MoneyChange {
    public static final long mod = 1000000007;

    private static long noOfWays(int[] coins, int n, int amount) {
        long[] dp = new long[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % mod;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(noOfWays(a, n, k));
        }
    }
}