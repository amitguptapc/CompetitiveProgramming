package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

public class H_Grid1 {
    private static long solve(int[][] grid, int m, int n) {
        long[][] dp = new long[m][n];
        long mod = 1000000007;
        for (int i = 0; i < m; i++)
            if (grid[i][0] == -1)
                break;
            else dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            if (grid[0][j] == -1)
                break;
            else dp[0][j] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (grid[i][j] != -1)
                    dp[i][j] = (dp[i - 1][j] % mod + dp[i][j - 1] % mod) % mod;

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        char[] s;
        for (int i = 0; i < m; i++) {
            s = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (s[j] == '.')
                    grid[i][j] = 1;
                else grid[i][j] = -1;
            }
        }
        System.out.println(solve(grid, m, n));
    }
}
