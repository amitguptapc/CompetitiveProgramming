package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// In how many ways can n friends go if they
// can either go alone or in pair

public class FriendsPairing {
    private static long pairing(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) // base case
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(pairing(n));
        }
    }
}