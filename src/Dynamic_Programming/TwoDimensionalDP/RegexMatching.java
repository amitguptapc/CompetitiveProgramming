package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class RegexMatching {
    /*
    dp[i][j] : true if pattern[0..i-1] is equal to text[0...j-1]
    */
    public static int doesMatch(char[] pat, char[] text) {
        int m = pat.length, n = text.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0) {
                    if (pat[i - 1] == '*')
                        dp[i][j] = i >= 2 && dp[i - 2][j];
                    else dp[i][j] = false;
                } else {
                    char pc = pat[i - 1];
                    char tc = text[j - 1];
                    if (pc == '*') {
                        dp[i][j] = i >= 2 && dp[i - 2][j];
                        if (i >= 2 && (pat[i - 2] == '.' || pat[i - 2] == tc))
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                    } else if (pc == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (pc == tc)
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] text = sc.next().toCharArray();
        char[] pat = sc.next().toCharArray();
        System.out.println(doesMatch(pat, text));
    }
}
