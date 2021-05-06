package Bitmasking_Challenges;

import java.util.Arrays;
import java.util.Scanner;

// https://www.spoj.com/problems/SUBSUMS/
public class SUBSUMS {
    private static int lowerBound(long x, long[] a, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] >= x)
                r = m;
            else l = m + 1;
        }
        return r;
    }

    private static int upperBound(long x, long[] a, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (a[m] <= x)
                l = m;
            else r = m - 1;
        }
        return l;
    }

    private static long[] findSubsetSum(long[] a, int n) {
        int m = (1 << n) - 1;
        long[] sum = new long[m + 1];
        int k;
        for (int i = 0; i <= m; i++) {
            k = i;
            long ans = 0;
            int j = 0;
            while (k > 0) {
                if ((k & 1) == 1)
                    ans += a[j];
                j++;
                k >>= 1;
            }
            sum[i] = ans;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();

        // divide array into 2 parts
        // Binary search in the second array
        int n1 = n / 2;
        int n2 = n - n1;
        long[] a1 = new long[n1];
        long[] a2 = new long[n2];
        for (int i = 0; i < n1; i++)
            a1[i] = sc.nextLong();
        for (int i = 0; i < n2; i++)
            a2[i] = sc.nextLong();
        long[] s1 = findSubsetSum(a1, n1);
        long[] s2 = findSubsetSum(a2, n2);
        Arrays.sort(s1);
        Arrays.sort(s2);

        long ans = 0;
        for (long value : s1) {
            long lb = a - value;
            long ub = b - value;
            int l = lowerBound(lb, s2, s2.length);
            int r = upperBound(ub, s2, s2.length);
            ans += r - l + 1;
        }
        System.out.println(ans);
    }
}
