import java.util.Scanner;

public class DiwaliPuzzle {
    private static int n, k;
    private static int[][][] dp;
    private static int mod = 1000003;

    private static long combination(int i, int prev, int count) {
        if (i == n) {
            if (count == k)
                return 1;
            else return 0;
        }
        if (dp[i][prev][count] != -1)
            return dp[i][prev][count];
        int ans = 0;
        if (prev == 1)  // if we put 1
            ans += combination(i + 1, 1, count + 1);
        else ans += combination(i + 1, 1, count);
        ans %= mod;
        // if we put 0
        ans += combination(i + 1, 0, count);
        ans %= mod;
        return dp[i][prev][count] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            dp = new int[105][3][105];
            for (int i = 0; i < 105; i++)
                for (int j = 0; j < 3; j++)
                    for (int l = 0; l < 105; l++)
                        dp[i][j][l] = -1;
            System.out.println((combination(1, 0, 0) + combination(1, 1, 0)) % mod);
        }
    }
}