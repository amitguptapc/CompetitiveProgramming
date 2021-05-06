package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class CoinChange {
    private static long[][] memo;

    private static long noOfWays(int[] coins, int i, int amount) {
        if (i < 0 || amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (memo[i][amount] != -1)
            return memo[i][amount];
        int ans = 0;
        ans += noOfWays(coins, i, amount - coins[i]) + noOfWays(coins, i - 1, amount);
        return memo[i][amount] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        memo = new long[n][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                memo[i][j] = -1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(noOfWays(a, n - 1, k));
    }
}