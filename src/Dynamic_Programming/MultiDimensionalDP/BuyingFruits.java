package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class BuyingFruits {
    /*
    dp[i][j] : min cost of buying fruits from shop 0,1..,i by selecting jth fruit from the ith shop
    */
    public static int getMinPrice(int[][] price, int n) {
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                dp[i] = price[i];
            else {
                dp[i][0] = price[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = price[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = price[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] price = new int[n][3];
            for (int i = 0; i < n; i++)
                price[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
            System.out.println(getMinPrice(price, n));
        }
    }
}
