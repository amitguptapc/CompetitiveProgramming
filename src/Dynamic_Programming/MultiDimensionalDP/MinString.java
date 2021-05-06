package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/string-reduction/problem
public class MinString {
    private static int[][][] dp;

    private static int getMin(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0)
            return 0;

        if (dp[a][b][c] != -1)
            return dp[a][b][c];

        // if any 2 characters are absent
        if (a == 0 && b == 0)
            return dp[a][b][c] = c;
        if (a == 0 && c == 0)
            return dp[a][b][c] = b;
        if (c == 0 && b == 0)
            return dp[a][b][c] = a;

        // if anyone character if absent
        if (a == 0)
            return dp[a][b][c] = getMin(a + 1, b - 1, c - 1);
        if (b == 0)
            return dp[a][b][c] = getMin(a - 1, b + 1, c - 1);
        if (c == 0)
            return dp[a][b][c] = getMin(a - 1, b - 1, c + 1);

        // if all characters are present
        return dp[a][b][c] = Math.min(getMin(a - 1, b - 1, c + 1),
                Math.min(getMin(a - 1, b + 1, c - 1),
                        getMin(a + 1, b - 1, c - 1)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] s = sc.next().toCharArray();
            int a = 0, b = 0, c = 0;
            for (char ch : s)
                if (ch == 'a')
                    a++;
                else if (ch == 'b')
                    b++;
                else c++;

            dp = new int[101][101][101];
            for (int i = 0; i <= 100; i++)
                for (int j = 0; j <= 100; j++)
                    for (int k = 0; k <= 100; k++)
                        dp[i][j][k] = -1;

            System.out.println(getMin(a, b, c));
        }
    }
}
