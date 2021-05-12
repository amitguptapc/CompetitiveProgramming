package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class MaxXORPermutation {
    private static long[][][][] dp;

    private static long getMax(int i, int b1, int b2, int b3) {
        if (i > 9 && b1 == 0 && b2 == 0 && b3 == 0)
            return 0;
        if (i > 9 || b1 < 0 || b2 < 0 || b3 < 0)
            return Integer.MIN_VALUE;
        if (dp[i][b1][b2][b3] != -1)
            return dp[i][b1][b2][b3];
        double ans;
        ans = Math.max(getMax(i + 1, b1, b2, b3), Math.pow(2, i) + getMax(i + 1, b1 - 1, b2 - 1, b3 - 1));
        ans = Math.max(ans, Math.pow(2, i) + getMax(i + 1, b1 - 1, b2, b3));
        ans = Math.max(ans, Math.pow(2, i) + getMax(i + 1, b1, b2 - 1, b3));
        ans = Math.max(ans, Math.pow(2, i) + getMax(i + 1, b1, b2, b3 - 1));
        ans = Math.max(ans, getMax(i + 1, b1 - 1, b2 - 1, b3));
        ans = Math.max(ans, getMax(i + 1, b1 - 1, b2, b3 - 1));
        ans = Math.max(ans, getMax(i + 1, b1, b2 - 1, b3 - 1));
        return dp[i][b1][b2][b3] = (long) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String p = sc.next();
            String q = sc.next();
            String r = sc.next();
            int b1 = 0, b2 = 0, b3 = 0;
            for (int i = 0; i < 10; i++) {
                if (p.charAt(i) == '1')
                    b1++;
                if (q.charAt(i) == '1')
                    b2++;
                if (r.charAt(i) == '1')
                    b3++;
            }

            dp = new long[11][11][11][11];
            for (int i = 0; i <= 10; i++)
                for (int j = 0; j <= 10; j++)
                    for (int k = 0; k <= 10; k++)
                        for (int l = 0; l <= 10; l++)
                            dp[i][j][k][l] = -1;

            System.out.println(Long.toBinaryString(getMax(0, b1, b2, b3)));
        }
    }
}
