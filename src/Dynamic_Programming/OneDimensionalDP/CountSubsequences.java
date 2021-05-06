package Dynamic_Programming.OneDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

public class CountSubsequences {
    /*
    dp[i] : no of subsequences if the string ends as (i-1)th index
    last[j] : last occurrence of j according to dp array
    */
    private static long mod = 1000000007;

    private static long findSubseq(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod) % mod;
            int c = s.charAt(i - 1) - 'A';
            if (last[c] != -1)
                dp[i] = (dp[i] % mod - dp[last[c] - 1] % mod + mod) % mod;
            last[c] = i;
        }
        return dp[n] % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(findSubseq(s));
        }
    }
}
