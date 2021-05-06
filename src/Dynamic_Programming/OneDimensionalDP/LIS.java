package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class LIS {
    private static int findLIS(int[] a, int n) {
        int[] dp = new int[n];            // here memo[i] stores the length of longest increasing subsequence
        for (int i = 0; i < n; i++)         // ending at that index
            dp[i] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (a[j] <= a[i])
                    dp[i] = Math.max(1 + dp[j], dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findLIS(a, n));
    }
}