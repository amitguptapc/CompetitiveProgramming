package Dynamic_Programming.TwoDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/array-splitting/problem
public class VivekLovesArray {
    private static long[] a;
    private static long[][] memo;

    private static long findSum(int i, int j) {
        long sum = 0;
        for (int k = i; k <= j; k++)
            sum += a[k];
        return sum;
    }

    public static long getMaxScore(int s, int e) {
        if (s >= e)
            return 0;
        if (memo[s][e] != -1)
            return memo[s][e];
        long max = 0;
        for (int i = s; i < e; i++) {
            if (findSum(s, i) == findSum(i + 1, e))
                max = Math.max(max, 1 + Math.max(getMaxScore(s, i), getMaxScore(i + 1, e)));
        }
        return memo[s][e] = max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextLong();
            memo = new long[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(memo[i], -1);
            System.out.println(getMaxScore(0, n - 1));
        }
    }
}
