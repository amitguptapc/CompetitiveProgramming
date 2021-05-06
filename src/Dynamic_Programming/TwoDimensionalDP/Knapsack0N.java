package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

// Also called Unbounded Knapsack
public class Knapsack0N {
    /*
    dp[i] : max value that can be achieved when capacity of knapsack is i
    */
    private static int[] wt, val;
    private static int n, cap;

    private static int solveKnapsack() {
        int[] dp = new int[cap + 1];

        for (int w = 0; w <= cap; w++)
            for (int i = 0; i < n; i++)
                if (w >= wt[i])
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);

        return dp[cap];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cap = sc.nextInt();
        wt = new int[n];
        val = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        System.out.println(solveKnapsack());
    }
}
