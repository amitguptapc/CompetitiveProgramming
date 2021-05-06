package Dynamic_Programming.TwoDimensionalDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ColorfulKnapsack {
    private static int getMaxWeight(HashMap<Integer, ArrayList<Integer>> group, int m, int x) {
        /*
        dp[i][j] : max weight obtained when stones of color 1,2...,i are selected and size of knapsack is j
        */
        int[][] dp = new int[m + 1][x + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = -1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= x; j++) {
                dp[i][j] = -1;
                for (int k : group.get(i)) {
                    if (k <= j && dp[i - 1][j - k] >= 0)
                        dp[i][j] = Math.max(dp[i][j], k + dp[i - 1][j - k]);
                }
            }
        }
        if (dp[m][x] != -1)
            return x - dp[m][x];
        return dp[m][x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> group = new HashMap<>();
        for (int i = 1; i <= m; i++)
            group.put(i, new ArrayList<>());
        int[] stones = new int[n];
        for (int i = 0; i < n; i++)
            stones[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            group.get(sc.nextInt()).add(stones[i]);
        System.out.println(getMaxWeight(group, m, x));
    }
}
