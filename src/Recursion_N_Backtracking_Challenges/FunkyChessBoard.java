package Recursion_N_Backtracking_Challenges;

import java.util.Scanner;

public class FunkyChessBoard {
    private static int n, ans;

    private static void getCells(int[][] grid, int r, int c, int count) {
        if (r >= n || r < 0 || c >= n || c < 0)
            return;
        if (grid[r][c] == 0)
            return;
        grid[r][c] = 0;
        ans = Math.max(ans, count + 1);
        getCells(grid, r + 1, c + 2, count + 1);
        getCells(grid, r + 2, c + 1, count + 1);
        getCells(grid, r - 2, c - 1, count + 1);
        getCells(grid, r - 1, c - 2, count + 1);
        getCells(grid, r + 2, c - 1, count + 1);
        getCells(grid, r - 2, c + 1, count + 1);
        getCells(grid, r + 1, c - 2, count + 1);
        getCells(grid, r - 1, c + 2, count + 1);
        grid[r][c] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int freeCells = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1)
                    freeCells++;
            }
        }
        ans = 0;
        getCells(grid, 0, 0, 0);
        System.out.println(freeCells - ans);
    }
}
