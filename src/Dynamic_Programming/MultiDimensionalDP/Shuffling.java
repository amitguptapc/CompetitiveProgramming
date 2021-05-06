package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

// https://www.codechef.com/problems/CHEFADD
public class Shuffling {
    private static long[][][][] dp;
    private static long c;

    private static int sum(int x, int y, int z) {
        return (x + y + z) % 2;
    }

    private static int carry(int x, int y, int z) {
        return (x + y + z) / 2;
    }

    private static long findWays(int i, int b1, int b2, int car) {
        if (b1 < 0 || b2 < 0)
            return 0;
        if (i == 31)
            return (car == 0 && b1 == 0 && b2 == 0) ? 1 : 0;
        if (dp[i][b1][b2][car] != -1)
            return dp[i][b1][b2][car];
        int ci = (c & (1L << i)) == 0 ? 0 : 1;
        long ans = 0;
        if (sum(0, 0, car) == ci)
            ans += findWays(i + 1, b1, b2, carry(0, 0, car));
        if (sum(0, 1, car) == ci)
            ans += findWays(i + 1, b1, b2 - 1, carry(0, 1, car));
        if (sum(1, 0, car) == ci)
            ans += findWays(i + 1, b1 - 1, b2, carry(1, 0, car));
        if (sum(1, 1, car) == ci)
            ans += findWays(i + 1, b1 - 1, b2 - 1, carry(1, 1, car));
        return dp[i][b1][b2][car] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            c = sc.nextLong();
            int b1 = Long.bitCount(a);
            int b2 = Long.bitCount(b);
            dp = new long[32][b1 + 1][b2 + 1][2];
            for (int i = 0; i < 32; i++)
                for (int j = 0; j <= b1; j++)
                    for (int k = 0; k <= b2; k++)
                        for (int l = 0; l < 2; l++)
                            dp[i][j][k][l] = -1;
            System.out.println(findWays(0, b1, b2, 0));
        }
    }
}
