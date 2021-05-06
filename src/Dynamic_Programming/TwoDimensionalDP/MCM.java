package TwoDimensionalDP;

import java.util.Scanner;

public class MCM {
    /*
    dp[i][j] : min cost to multiply matrices Mi, Mi+1,......Mj-1, Mj
    */
    private static int minCost(int[] a, int n) {
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            int s = 0, e = i;
            while (e < n) {
                dp[s][e] = Integer.MAX_VALUE;
                for (int j = s; j < e; j++)
                    dp[s][e] = Math.min(dp[s][e], dp[s][j] + dp[j + 1][e] + a[s] * a[j + 1] * a[e + 1]);
                s++;
                e++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++)
            a[i] = sc.nextInt();
        System.out.println(minCost(a, n));
    }

}