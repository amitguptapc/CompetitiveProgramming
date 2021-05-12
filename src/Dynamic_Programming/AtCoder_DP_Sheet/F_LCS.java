package Dynamic_Programming.AtCoder_DP_Sheet;

import java.util.Scanner;

public class F_LCS {
    private static String solve(char[] s, char[] t) {
        int m = s.length, n = t.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        String res = "";
        while (i > 0 && j > 0) {
            if (s[i - 1] == t[j - 1]) {
                res = s[i - 1] + res;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();
        System.out.println(solve(s, t));
    }
}
