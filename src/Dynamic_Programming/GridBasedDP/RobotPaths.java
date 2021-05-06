package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// https://www.codechef.com/problems/CD1IT4

public class RobotPaths {
    private static int[][] dp;
    private static int m, n, mod = 1000000007;

    private static int findPaths() {
        if (dp[0][0] == -1 || dp[m - 1][n - 1] == -1)  // if first or last cell is blocked
            return 0;
        // filling first row
        for (int j = 0; j < n; j++) {
            if (dp[0][j] == -1)
                break;
            dp[0][j] = 1;
        }
        // filling first column
        for (int i = 0; i < m; i++) {
            if (dp[i][0] == -1)
                break;
            dp[i][0] = 1;
        }
        // rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == -1) // blocked cell
                    continue;
                if (dp[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                if (dp[i][j - 1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int p = sc.nextInt();
        dp = new int[m][n];
        for (int i = 0; i < p; i++)
            dp[sc.nextInt() - 1][sc.nextInt() - 1] = -1;
        System.out.println(findPaths());
    }
}