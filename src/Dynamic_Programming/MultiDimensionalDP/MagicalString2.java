package Dynamic_Programming.MultiDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class MagicalString2 {
    private static char[] s;
    private static int[] f;
    private static int n;

    private static boolean isValid(int i, int j) {
        int l = j - i + 1;
        for (int x = i; x <= j; x++)
            if (f[s[x] - 'a'] < l)
                return false;
        return true;
    }

    private static int solve() {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (isValid(j - 1, i - 1))
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next().toCharArray();
        f = new int[26];
        for (int i = 0; i < 26; i++)
            f[i] = sc.nextInt();
        System.out.println(solve());
    }
}
