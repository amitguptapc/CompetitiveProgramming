package Bitmasking;

import java.util.Scanner;

// Print all possible combinations using Bitmask
public class NQueenBitmask {
    private static int n, end, ans = 0;
    private static int[][] board;

    private static int getPos(int n) {
        int pos = 0;
        while (n > 0) {
            pos++;
            n >>= 1;
        }
        return pos - 1;
    }

    private static void solve(int rowMask, int ld, int rd, int row) {
        if (rowMask == end) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            ans++;
            return;
        }
        int safe = end & ~(rowMask | ld | rd); // remove extra bits
        while (safe > 0) {
            int p = safe & -safe; // find a place to fill queen
            safe -= p; // remove that place
            int col = getPos(p);
            board[row][col] = 1;
            solve(rowMask | p, (ld | p) << 1, (rd | p) >> 1, row + 1);
            board[row][col] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        end = (1 << n) - 1;
        board = new int[n][n];
        solve(0, 0, 0, 0);
        System.out.println(ans);
    }
}
