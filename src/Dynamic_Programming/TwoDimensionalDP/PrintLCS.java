package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class PrintLCS {
    private static char[] r, s;
    private static int m, n;

    private static void printLCS() {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (r[i - 1] == s[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // Print LCS logic
        int i = m, j = n;
        String res = "";
        while (i > 0 && j > 0) {
            if (r[i - 1] == s[j - 1]) {
                res = r[i - 1] + res;
                i--;
                j--;
            } else if (dp[i][j - 1] >= dp[i - 1][j])
                j--;
            else i--;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.next().toCharArray();
        s = sc.next().toCharArray();
        m = r.length;
        n = s.length;
        printLCS();
    }
}