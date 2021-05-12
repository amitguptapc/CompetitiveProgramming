package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

// https://www.spoj.com/problems/SQRBR/
public class SquareBrackets {
    private static int n;
    private static boolean[] openB;
    private static long mod = 1000000007;
    private static long[][] dp;

    private static long getBrackets(int open, int pos) {
        if (open < 0)
            return 0;
        if (pos == 2 * n)
            return open == 0 ? 1 : 0;

        if (dp[open][pos] != -1)
            return dp[open][pos];

        if (openB[pos])
            return dp[open][pos] = getBrackets(open + 1, pos + 1) % mod;
        long ans = (
                getBrackets(open + 1, pos + 1) % mod  // [ is placed
                        + getBrackets(open - 1, pos + 1) % mod) % mod; // ] is placed

        return dp[open][pos] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int k = sc.nextInt();
            openB = new boolean[2 * n];
            for (int i = 0; i < k; i++)
                openB[sc.nextInt() - 1] = true;

            dp = new long[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++)
                for (int j = 0; j < 2 * n; j++)
                    dp[i][j] = -1;

            System.out.println(getBrackets(0, 0));
        }
    }
}
