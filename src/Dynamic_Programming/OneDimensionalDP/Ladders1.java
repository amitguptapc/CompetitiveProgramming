package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class Ladders1 {
    private static int findWays(int[] a, int n, int k) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (a[i - 1] == 0) {
                for (int j = 1; j <= k; j++) {
                    if (i - j > 0)
                        dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findWays(a, n, k));
    }
}
