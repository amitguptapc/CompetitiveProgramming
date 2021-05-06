package BitmaskDP;

import java.io.*;
import java.util.*;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 08/10/19
 * Time : 12:11 PM
 * Problem Code : TSHIRTS
 * Platform : CodeChef
 */

public class TSHIRTS {

    private static long MOD = 1000000007;
    private static int allGot;
    private static ArrayList<ArrayList<Integer>> map;
    private static long[][] dp;

    private static long solve(int mask, int tid) {
        if (mask == allGot) // if everyone got a T-shirt
            return 1;
        if (tid == 101) // if all T-shirts are exhausted
            return 0;
        if (dp[mask][tid] != -1)
            return dp[mask][tid];
        long ans = solve(mask, tid + 1) % MOD; // if current T-shirt is not given to anyone
        for (int p : map.get(tid)) {
            if ((mask & (1 << p)) == 0)
                ans = (ans + solve(mask | (1 << p), tid + 1)) % MOD;
        }
        return dp[mask][tid] = ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            allGot = (1 << n) - 1;
            map = new ArrayList<>();
            for (int i = 0; i < 101; i++)
                map.add(new ArrayList<>());
            for (int k = 0; k < n; k++) {
                String[] s = br.readLine().split(" ");
                for (String value : s) {
                    int j = Integer.parseInt(value);
                    ArrayList<Integer> l = map.get(j);
                    l.add(k);
                }
            }
            dp = new long[(1 << n) + 1][101];
            for (int i = 0; i <= 1 << n; i++)
                for (int j = 0; j <= 100; j++)
                    dp[i][j] = -1;
            System.out.println(solve(0, 1));
        }
    }
}