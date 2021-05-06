package Recursion_N_Backtracking_Challenges;

import java.util.Scanner;

public class ExpandPond {
    private static int n, m;
    private static int largestSize = 0;

    private static void findLargestPond(int[][] pond, int r, int c, int size) {
        if (r >= n || c >= m || r < 0 || c < 0)
            return;
        if (pond[r][c] == 0)
            return;
        pond[r][c] = 0;
        largestSize = Math.max(largestSize, size + 1);
        findLargestPond(pond, r + 1, c, size + 1);
        findLargestPond(pond, r - 1, c, size + 1);
        findLargestPond(pond, r, c + 1, size + 1);
        findLargestPond(pond, r, c - 1, size + 1);
        pond[r][c] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] pond = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                pond[i][j] = sc.nextInt();
        findLargestPond(pond, 0, 0, 1);
        System.out.println(largestSize);
    }
}
