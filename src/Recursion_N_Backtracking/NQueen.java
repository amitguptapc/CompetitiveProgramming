package Backtracking;

import java.util.Scanner;

public class NQueen {
    private static boolean isSafe(int[][] board, int x, int y, int n) {
        //checking the column
        for (int i = x; i >= 0; i--)
            if (board[i][y] == 1)
                return false;

        // checking the left diagonal
        int i = x, j = y;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 1)
                return false;
        }

        // checking the right diagonal
        i = x;
        j = y;
        while (i >= 0 && j < n) {
            if (board[i--][j++] == 1)
                return false;
        }
        return true;
    }

    private static boolean solve(int[][] board, int r, int n) {
        // base case - if all the queens are placed
        if (r == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            return true; // if set to false it will print all the possible solutions
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, r, i, n)) {
                board[r][i] = 1;
                if (solve(board, r + 1, n))
                    return true;
                // backtracking
                board[r][i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        solve(board, 0, n);
    }
}