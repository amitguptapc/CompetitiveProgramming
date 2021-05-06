package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class MaxPower {
    /*
    dp[i][0] : maximum positive product ending at ith index
    dp[i][1] : maximum negative product ending at ith index
    */
    private static long findMaxProduct(long[] a, int n) {
        long[][] dp = new long[n][2];
        if (a[0] > 0)
            dp[0][0] = a[0];
        else dp[0][1] = a[0];

        long max = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > 0) {
                dp[i][0] = Math.max(a[i], a[i] * dp[i - 1][0]);
                dp[i][1] = a[i] * dp[i - 1][1];
            } else {
                dp[i][0] = a[i] * dp[i - 1][1];
                dp[i][1] = Math.min(a[i], a[i] * dp[i - 1][0]);
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(findMaxProduct(a, n));
    }
}
