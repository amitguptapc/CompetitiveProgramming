package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// https://www.codechef.com/problems/SSJG
public class GoldGrid {
    private static long[][] grid;
    private static int n;

    private static long maxCoins() {
        int i, j;
        for (i = 0; i < n; i++)
            for (j = 1; j < n; j++)
                grid[i][j] += grid[i][j - 1];
        for (j = 0; j < n; j++)
            for (i = 1; i < n; i++)
                grid[i][j] += grid[i - 1][j];

        long max = 0, min, a, b, c, d;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a = grid[i][j];
                b = grid[i][n - 1] - a;
                c = grid[n - 1][j] - a;
                d = grid[n - 1][n - 1] - b - c - a;
                min = Math.min(a, Math.min(b, Math.min(c, d)));
                max = Math.max(min, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int m = sc.nextInt();
            grid = new long[n][n];
            while (m-- > 0)
                grid[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
            System.out.println(maxCoins());
        }
    }
}
