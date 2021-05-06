package Dynamic_Programming.TwoDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSumEasy {
    private static int[][] dp;
    private static int maxSum = 100000;

    public static int solve(int i, int[] a, int n, int sum) {
        /*
        dp[i][j] = no of subsets of a[0,1,..,i] with sum j-maxSum
        maxSum is added for coordinate compression i.e. to make the negative index positive
        */
        if (sum == 0 && i == n)
            return 1;
        if (i == n)
            return 0;
        if (dp[i][sum + maxSum] != -1)
            return dp[i][sum + maxSum];
        return dp[i][sum + maxSum] = solve(i + 1, a, n, sum + a[i]) + solve(i + 1, a, n, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            dp = new int[n][10 * maxSum];
            for (int i = 0; i < n; i++)
                Arrays.fill(dp[i], -1);
            System.out.println(solve(0, a, n, 0) == 1 ? "No" : "Yes");
        }
    }
}
