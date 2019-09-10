import java.util.Scanner;

// Find the minimum no of attempts to find the critical floor
// Given there are n floors and k eggs
public class EggDropPuzzle {
    private static int attempts(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        int res;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 1; l <= i; l++) {
                    res = 1 + Math.max(
                            dp[l - 1][j - 1], // when egg breaks we are left with l-1 floors and j-1 eggs
                            dp[i - l][j]  // when egg doesn't break we are left with i-l floors and j eggs
                    );
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // floors
        int k = sc.nextInt(); // eggs
        System.out.println(attempts(n, k));
    }
}