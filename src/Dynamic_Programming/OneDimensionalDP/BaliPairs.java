package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// https://www.codechef.com/problems/JCWC02
public class BaliPairs {
    private static final long mod = 1000000007;

    /*
    dp[i][0] : no of combinations with even sum up till index i
    dp[i][1] : no of combinations with odd sum up till index i
    */
    private static long findPairs(int[][] shoes, int n) {
        long[][] dp = new long[n][2];
        dp[0][1] = shoes[0][0] % 2 + shoes[0][1] % 2;
        dp[0][0] = 2 - dp[0][1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (shoes[i][j] % 2 == 0) {
                    dp[i][0] = (dp[i][0] + dp[i - 1][0]) % mod;
                    dp[i][1] = (dp[i][1] + dp[i - 1][1]) % mod;
                } else {
                    dp[i][0] = (dp[i][0] + dp[i - 1][1]) % mod;
                    dp[i][1] = (dp[i][1] + dp[i - 1][0]) % mod;
                }
            }
        }
        return dp[n - 1][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] shoes = new int[n][2];
        for (int i = 0; i < n; i++) {
            shoes[i][0] = sc.nextInt();
            shoes[i][1] = sc.nextInt();
        }
        System.out.println(findPairs(shoes, n));
    }
}
