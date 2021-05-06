package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// find no of ways to reach nth step
// if we can take jumps in between 1 and k
public class StaircaseProblem {
    private static int findWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        // at each step no of ways is equal to the sum of values at previous k steps
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= i - k && j >= 0; j--) {
                dp[i] += dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findWays(n, k));
    }
}