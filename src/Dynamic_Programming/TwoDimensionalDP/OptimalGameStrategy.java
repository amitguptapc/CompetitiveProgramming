package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

public class OptimalGameStrategy {
    private static int winnerScore(int[] a, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int s = 0, e = i;
            while (e < n) {
                if (s == e) // only one element left to be picked
                    dp[s][e] = a[s];
                else if (s + 1 == e) // two elements are left to be picked
                    dp[s][e] = Math.max(a[s], a[e]);
                else {
                    int x = dp[s + 1][e - 1];
                    int y = dp[s + 2][e];
                    int z = dp[s][e - 2];
                    dp[s][e] = Math.max(a[s] + Math.min(x, y), a[e] + Math.min(z, x));
                }
                s++;
                e++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(winnerScore(a, n));
    }
}