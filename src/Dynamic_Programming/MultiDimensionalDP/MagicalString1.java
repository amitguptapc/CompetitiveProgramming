package Dynamic_Programming.MultiDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class MagicalString1 {
    private static final long mod = 1000000007;
    private static char[] s;
    private static int[] f;

    private static boolean isValid(int i, int j) {
        int l = j - i + 1;
        for (int x = i; x <= j; x++)
            if (f[s[x] - 'a'] < l)
                return false;
        return true;
    }

    private static long solve(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (isValid(j, i))
                    dp[i] += dp[j];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.next().toCharArray();
        f = new int[26];
        for (int i = 0; i < 26; i++)
            f[i] = sc.nextInt();
        System.out.println(solve(n));
    }
}
