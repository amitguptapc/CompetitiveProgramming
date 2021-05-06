package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class AllOnes {
    /*
    dp[i][j] : largest square ending at (i,j) (bottom-right end of the square)
    */
    public static int findLargestSquare(int[][] a, int n, int m) {
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = a[i][j];
                else {
                    if (a[i][j] == 0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        System.out.println(findLargestSquare(a, n, m));
    }
}
