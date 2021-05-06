package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// Find total number of paths for a rook from (0,0) to (m-1,n-1)
// In one step Rook(Elephant) can can move any no of steps right or any no of steps down
public class RookWays {
    private static int minCost(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (i == 0) {
                    for (int k = 0; k < j; k++)
                        dp[i][j] += dp[i][k];
                } else if (j == 0) {
                    for (int k = 0; k < i; k++)
                        dp[i][j] += dp[k][j];
                } else {
                    for (int k = 0; k < i; k++)
                        dp[i][j] += dp[k][j];
                    for (int l = 0; l < j; l++)
                        dp[i][j] += dp[i][l];
                }
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