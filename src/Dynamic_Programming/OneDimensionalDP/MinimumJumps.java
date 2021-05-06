package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class MinimumJumps {
    /*
    dp[i] : minimum no of jumps required to reach last cell starting from ith cell
    */
    public static int findMinJumps(int[] a, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] >= n - 1 - i)
                dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + a[i]; j++) {
                    min = Math.min(min, dp[j]);
                }
                dp[i] = 1 + min;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findMinJumps(a, n));
    }
}
