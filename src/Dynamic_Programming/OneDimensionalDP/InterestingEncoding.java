package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/acode-alphacode-3/
public class InterestingEncoding {
    private static long findWays(char[] s) {
        int n = s.length;
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == '0' && s[i - 1] == '0') {
                dp[i] = 0;
            } else if (s[i] != '0' && s[i - 1] == '0') {
                dp[i] = dp[i - 1];
            } else if (s[i] == '0' && s[i - 1] != '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2')
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                else dp[i] = 0;
            } else {
                if (Integer.parseInt(s[i - 1] + "" + s[i]) <= 26)
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                else dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("0"))
                break;
            System.out.println(findWays(s.toCharArray()));
        }
    }
}
