package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class LCS3Strings {
    private static int findLCS(String a, String b, String c) {
        int x = a.length(), y = b.length(), z = c.length();
        int[][][] dp = new int[x + 1][y + 1][z + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        dp[i][j][k] = 0;
                    else if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1))
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    else
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }
        return dp[x][y][z];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        System.out.println(findLCS(a, b, c));
    }
}
