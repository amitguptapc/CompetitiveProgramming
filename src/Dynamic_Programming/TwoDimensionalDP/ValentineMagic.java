package Dynamic_Programming.TwoDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

// Problem involving DP and Greedy
// https://hack.codingblocks.com/contests/c/668/825
public class ValentineMagic {
    private static long[][] memo;
    private static int n, m;
    private static int[] a, b;

    private static long findDiff(int i, int j) {
        if (i == n) // all boys are paired
            return 0;

        if (j == m) // no girls are available
            return Integer.MAX_VALUE; // using long will lead to overflow

        if (memo[i][j] != -1)
            return memo[i][j];

        long x = Math.abs(a[i] - b[j]) + findDiff(i + 1, j + 1); // ith boy and jth girl are paired
        long y = findDiff(i, j + 1); // ith boy is not paired with jth girl

        return memo[i][j] = Math.min(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // no of boys
        m = sc.nextInt(); // no of girls
        a = new int[n]; // for chocolates
        b = new int[m]; // for candies
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int j = 0; j < m; j++)
            b[j] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        memo = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                memo[i][j] = -1;
        System.out.println(findDiff(0, 0));
    }
}