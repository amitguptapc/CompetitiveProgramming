package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class StringsOfABC {
    private static long[][][] dp;

    private static long getWays(int i, int b, int c) {
        if (i == 0)
            return 1;

        if (dp[i][b][c] != -1)
            return dp[i][b][c];

        long ans = 0;
        if (b > 0)
            ans += getWays(i - 1, b - 1, c); // when b is used
        if (c > 0)
            ans += getWays(i - 1, b, c - 1); // when c is used
        ans += getWays(i - 1, b, c); // when a is used

        return dp[i][b][c] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            dp = new long[n + 1][2][3];
            for (int i = 0; i <= n; i++)
                for (int j = 0; j < 2; j++)
                    for (int k = 0; k < 3; k++)
                        dp[i][j][k] = -1;

            System.out.println(getWays(n, 1, 2));
        }
    }
}