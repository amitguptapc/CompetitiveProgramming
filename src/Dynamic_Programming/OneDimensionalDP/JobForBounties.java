package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class JobForBounties {
    private static long findMax(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        if (c[1] == ')' && c[0] == '(')
            dp[1] = 2;
        int max = dp[1];
        for (int i = 2; i < n; i++) {
            if (c[i] == ')') {
                if (c[i - 1] == '(')
                    dp[i] = dp[i - 2] + 2;
                else if (c[i - 1] == ')') {
                    if (i - dp[i - 1] - 1 >= 0 && c[i - dp[i - 1] - 1] == '(')
                        dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0)
                        dp[i] += dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findMax(s));
    }
}