package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class SportsFest {
    private static long mod = 1000000007;

    private static long findWays(int n) {
        /*
        0 : cricket
        1 : football
        2 : hockey
        dp[i][j][k] : no of ways of organizing fest of i days given today jth game
        will be played and kth game was played yesterday
        */
        long[][][] dp = new long[n + 1][3][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][2][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][0][1] = (dp[i - 1][1][0] + dp[i - 1][1][2]) % mod;
            dp[i][0][2] = (dp[i - 1][2][0] + dp[i - 1][2][1]) % mod;
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][1][1] = 0;
            dp[i][1][2] = (dp[i - 1][2][0] + dp[i - 1][2][1]) % mod;
            dp[i][2][0] = (dp[i - 1][0][0] + dp[i - 1][0][1]) % mod;
            dp[i][2][1] = dp[i - 1][1][0];
            dp[i][2][2] = 0;
        }
        return (dp[n][0][0] + dp[n][0][1] + dp[n][1][0] + dp[n][0][2] + dp[n][2][0] + dp[n][1][2] + dp[n][2][1]) % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findWays(n));
    }
}
