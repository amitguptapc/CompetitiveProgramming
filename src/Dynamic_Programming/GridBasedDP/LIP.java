package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Longest Increasing Path
public class LIP {
    private static int m, n;
    private static int[][] matrix, dp;
    private static int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static int dfs(int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];

        int nx, ny, ans = 1;
        for (int i = 0; i < 4; i++) {
            nx = x + move[i][0];
            ny = y + move[i][1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;
            if (matrix[nx][ny] <= matrix[x][y])
                continue;
            ans = Math.max(ans, 1 + dfs(nx, ny));
        }

        return dp[x][y] = ans;
    }

    private static int getLIP() {
        dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(getLIP());
    }
}
