package Recursion_N_Backtracking_Challenges;

import java.util.Scanner;

public class NQueenHard {
    private static long ways = 0;
    private static int n;

    private static boolean isafe(int[][] grid, int r, int c) {
        for (int i = r; i >= 0; i--)
            if (grid[i][c] == 1)
                return false;
        int i = r, j = c;
        while (i >= 0 && j >= 0)
            if (grid[i--][j--] == 1)
                return false;
        i = r;
        j = c;
        while (i >= 0 && j < n)
            if (grid[i--][j++] == 1)
                return false;
        return true;
    }

    private static boolean solve(int[][] grid, int r) {
        if (r == n) {
            ways++;
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (isafe(grid, r, i)) {
                grid[r][i] = 1;
                if (solve(grid, r + 1))
                    return true;
                grid[r][i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        solve(grid, 0);
        System.out.println(ways);
    }
}
