package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

// https://atcoder.jp/contests/dp/tasks/dp_a
public class A_Frog1 {
    private static int getMin(int[] a, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                dp[0] = 0;
            else if (i == 1)
                dp[1] = Math.abs(a[0] - a[1]);
            else
                dp[i] = Math.min(
                        dp[i - 1] + Math.abs(a[i] - a[i - 1]),
                        dp[i - 2] + Math.abs(a[i] - a[i - 2])
                );
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(getMin(a, n));
    }
}
