package BitmaskDP;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/401/D
public class VipulAndModulos {
    private static int m, l;
    private static char[] n;
    private static long[][] dp;

    private static long solve(int mask, int mod) {
        if (mask == (1 << l) - 1)
            return mod == 0 ? 1 : 0;

        if (dp[mask][mod] != -1)
            return dp[mask][mod];

        long ans = 0;
        boolean[] active = new boolean[10];
        for (int i = 0; i < l; i++) {
            if (n[i] == '0' && mask == 0)
                continue;
            if ((mask & (1 << i)) == 0 && !active[n[i] - '0']) {
                ans += solve(mask | (1 << i), (mod * 10 + (n[i] - '0')) % m);
                active[n[i] - '0'] = true;
            }
        }

        return dp[mask][mod] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.next().toCharArray();
            m = sc.nextInt();
            l = n.length;

            dp = new long[(1 << l) + 1][m + 1];
            for (int i = 0; i <= (1 << l); i++)
                for (int j = 0; j <= m; j++)
                    dp[i][j] = -1;

            System.out.println(solve(0, 0));
        }
    }
}