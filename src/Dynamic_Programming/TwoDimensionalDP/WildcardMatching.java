package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class WildcardMatching {
    /*
    dp[i][j] : pattern[0...i-1] matches text[0...j-1] or not
    */
    private static int isMatch(char[] pattern, char[] text) {
        int m = pattern.length;
        int n = text.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) // when both strings are null
                    dp[i][j] = true;
                else if (i == 0) // when pattern is null
                    dp[i][j] = false;
                else if (j == 0) {
                    if (pattern[i - 1] == '*') // when text is null and pattern is *
                        dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = false;
                } else {
                    if (pattern[i - 1] == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (pattern[i - 1] == '*')
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    else if (pattern[i - 1] == text[j - 1])
                        dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = false;
                }
            }
        }
        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] text = sc.next().toCharArray();
        char[] pattern = sc.next().toCharArray();
        System.out.println(isMatch(pattern, text));
    }
}