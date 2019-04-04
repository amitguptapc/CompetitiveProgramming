import java.util.Scanner;

public class MinCostPath {
    private static int minCost(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //base case
        // fill first row
        for (int c = 1; c < n; c++)
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        // fill first column
        for (int r = 1; r < m; r++)
            dp[r][0] = dp[r - 1][0] + grid[r][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m * n; i++)
            grid[i / n][i % n] = sc.nextInt();
        System.out.println(minCost(grid, m, n));
    }
}