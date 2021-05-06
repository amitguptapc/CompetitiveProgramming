package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// Find total number of paths from (0,0) to (m-1,n-1)
// In one step rat can can move 1 step right or 1 step down
public class RatWays {
    private static int minCost(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(minCost(m, n));
    }
}