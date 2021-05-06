package Dynamic_Programming.MultiDimensionalDP;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RockScissorPaper {
    private static double[][][] dp;

    private static double rockSurvivor(int r, int s, int p) {
        if (r == 0 || s == 0)
            return 0;
        if (p == 0)
            return 1;
        if (dp[r][s][p] != -1)
            return dp[r][s][p];
        double total = (r * s) + (s * p) + (p * r);
        double ans = 0;
        ans += rockSurvivor(r - 1, s, p) * ((r * p) / total); // paper kills rock
        ans += rockSurvivor(r, s - 1, p) * ((r * s) / total);  // rock kills scissor
        ans += rockSurvivor(r, s, p - 1) * ((s * p) / total);  // scissor kills paper
        return dp[r][s][p] = ans;
    }

    private static double scissorSurvivor(int r, int s, int p) {
        if (p == 0 || s == 0)
            return 0;
        if (r == 0)
            return 1;
        if (dp[r][s][p] != -1)
            return dp[r][s][p];
        double total = (r * s) + (s * p) + (p * r);
        double ans = 0;
        ans += scissorSurvivor(r - 1, s, p) * ((r * p) / total); // paper kills rock
        ans += scissorSurvivor(r, s - 1, p) * ((r * s) / total);  // rock kills scissor
        ans += scissorSurvivor(r, s, p - 1) * ((s * p) / total);  // scissor kills paper
        return dp[r][s][p] = ans;
    }

    private static double paperSurvivor(int r, int s, int p) {
        if (p == 0 || r == 0)
            return 0;
        if (s == 0)
            return 1;
        if (dp[r][s][p] != -1)
            return dp[r][s][p];
        double total = (r * s) + (s * p) + (p * r);
        double ans = 0;
        ans += paperSurvivor(r - 1, s, p) * ((r * p) / total); // paper kills rock
        ans += paperSurvivor(r, s - 1, p) * ((r * s) / total);  // rock kills scissor
        ans += paperSurvivor(r, s, p - 1) * ((s * p) / total);  // scissor kills paper
        return dp[r][s][p] = ans;
    }

    private static void initialize(int r, int s, int p) {
        for (int i = 0; i <= r; i++)
            for (int j = 0; j <= s; j++)
                for (int k = 0; k <= p; k++)
                    dp[i][j][k] = -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            dp = new double[r + 1][s + 1][p + 1];
            initialize(r, s, p);
            double x = rockSurvivor(r, s, p);
            initialize(r, s, p);
            double y = scissorSurvivor(r, s, p);
            initialize(r, s, p);
            double z = paperSurvivor(r, s, p);
            DecimalFormat df = new DecimalFormat("#0.000000000");
            System.out.println(df.format(x) + " " + df.format(y) + " " + df.format(z));
        }
    }
}

/*
3
2 2 2
2 1 2
1 1 3
 */