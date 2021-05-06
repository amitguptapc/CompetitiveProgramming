package Dynamic_Programming.TwoDimensionalDP;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/1114/D
public class FloodFill {
    /*
    dp[i][j] : no of operations required to convert a[i,..,j] into single color
    */
    private static int minTurns(int[] a, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = i;
            while (r < n) {
                if (l == r)
                    dp[l][r] = 0;
                else if (l == r - 1)
                    dp[l][r] = 1;
                else {
                    if (a[l] == a[r])
                        dp[l][r] = dp[l + 1][r - 1] + 1;
                    else dp[l][r] = 1 + Math.min(dp[l][r - 1], dp[l + 1][r]);
                }
                l++;
                r++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1, cur;
        for (int i = 0; i < n; i++) {
            cur = sc.nextInt();
            if (cur != prev)
                list.add(cur);
            prev = cur;
        }
        n = list.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = list.get(i);
        System.out.println(minTurns(a, n));
    }
}
