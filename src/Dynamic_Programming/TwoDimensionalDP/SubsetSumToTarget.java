package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class SubsetSumToTarget {
    private static String solve(int[] a, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0)
                    dp[i][j] = true;
                else {
                    dp[i][j] = dp[i - 1][j]; // if current element does not contribute
                    if (j >= a[i - 1])
                        dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]]; // if current element contributes
                }
            }
        }
        return dp[n][sum] ? "Yes" : "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(solve(a, n, sum));
    }
}
