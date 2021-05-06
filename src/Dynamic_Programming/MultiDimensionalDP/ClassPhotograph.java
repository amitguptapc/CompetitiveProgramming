package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class ClassPhotograph {
    private static final long mod = 1000000007;
    private static int n1, n2;
    private static long[][][][] dp;

    private static long findWays(int b, int g, int cb, int cg) {
        if (b == 0 && g == 0)
            return 1;

        if (dp[b][g][cb][cg] != -1)
            return dp[b][g][cb][cg];

        long ans = 0;
        if (b != 0 && cb < n1)
            ans = (ans + findWays(b - 1, g, cb + 1, 0) % mod) % mod;
        if (g != 0 && cg < n2)
            ans = (ans + findWays(b, g - 1, 0, cg + 1) % mod) % mod;

        return dp[b][g][cb][cg] = ans % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int g = sc.nextInt();
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        dp = new long[b + 1][g + 1][n1 + 1][n2 + 1];
        for (int i = 0; i <= b; i++)
            for (int j = 0; j <= g; j++)
                for (int k = 0; k <= n1; k++)
                    for (int l = 0; l <= n2; l++)
                        dp[i][j][k][l] = -1;

        System.out.println(findWays(b, g, 0, 0));
    }
}
