package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class VipulAndQueries {
    private static int[][][] dp;

    private static void solve(int[][] balls, int n) {
        dp = new int[n + 1][101][101];
        for (int i = 1; i <= n; i++) {
            for (int blue = 0; blue <= 100; blue++) {
                for (int red = 0; red <= 100; red++) {
                    dp[i][blue][red] = dp[i - 1][blue][red];
                    if (balls[i][0] <= blue && balls[i][1] <= red)
                        dp[i][blue][red] = Math.max(dp[i][blue][red],
                                1 + dp[i - 1][blue - balls[i][0]][red - balls[i][1]]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] balls = new int[n + 1][n + 1]; // 1st index for blue balls, 2nd index for red balls
        for (int i = 1; i <= n; i++) {
            for (char c : sc.next().toCharArray()) {
                if (c == 'B')
                    balls[i][0]++;
                else balls[i][1]++;
            }
        }
        solve(balls, n);
        int q = sc.nextInt();
        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(dp[n][b][a]);
        }
    }
}