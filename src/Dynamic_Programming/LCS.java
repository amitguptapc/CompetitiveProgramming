import java.util.Scanner;

public class LCS {
    private static int[][] memo;

    // Pure DP
    private static int lcs3(String r, String s) {
        int m = r.length(), n = s.length();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (r.charAt(i - 1) == s.charAt(j - 1))
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m][n];
    }

    // Memoization
    private static int lcs2(String r, String s) {
        int m = r.length(), n = s.length();
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (r.charAt(0) == s.charAt(0))
            memo[m][n] = 1 + lcs2(r.substring(1), s.substring(1));
        else
            memo[m][n] = Math.max(lcs2(r, s.substring(1)), lcs2(r.substring(1), s));
        return memo[m][n];
    }

    // Naive
    private static int lcs1(String r, String s) {
        if (r.length() == 0 || s.length() == 0)
            return 0;
        if (r.charAt(0) == s.charAt(0))
            return 1 + lcs1(r.substring(1), s.substring(1));
        return Math.max(lcs1(r.substring(1), s), lcs1(r, s.substring(1)));
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        String s = sc.next();
        int m = r.length() + 1, n = s.length() + 1;
        memo = new int[m][n];
        for (int i = 0; i < m * n; i++)
            memo[i / n][i % n] = -1;
        System.out.println(lcs3(r, s));
    }
}