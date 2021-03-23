import java.util.Scanner;

// https://hack.codingblocks.com/contests/c/204/646

// Advanced DP
public class CellMitosis {
    private static int x, y, z;

    private static long cellMitosis(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) // even case
                dp[i] = Math.min(
                        dp[i / 2] + x, // doubling the cells
                        dp[i - 1] + y  // increase cells by 1
                );
            else dp[i] = Math.min(
                    dp[i - 1] + y, // increase cells by 1
                    dp[(i + 1) / 2] + x + z // double the cells and decrease by 1
            );

        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        System.out.println(cellMitosis(n));
    }
}