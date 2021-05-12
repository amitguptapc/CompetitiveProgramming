package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

// https://atcoder.jp/contests/dp/tasks/dp_b
public class B_Frog2 {
    private static int getMin(int[] a, int n, int k) {
        int[] dp = new int[n];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0)
                    ans = Math.min(ans, dp[i - j] + Math.abs(a[i] - a[i - j]));
                else break;
            }
            dp[i] = ans;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(getMin(a, n, k));
    }
}
