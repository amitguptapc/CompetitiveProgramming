package src.Mathematics;

import java.util.Scanner;

public class SEQ_Spoj {
    private static long MOD = 1000000000;
    private static int k;
    private static long[] b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            k = sc.nextInt();
            b = new long[k];
            c = new long[k];
            for (int i = 0; i < k; i++)
                b[i] = sc.nextLong();
            for (int i = 0; i < k; i++)
                c[i] = sc.nextLong();
            int n = sc.nextInt();
            System.out.println(calculate(n));
            t--;
        }
    }

    private static long calculate(int n) {
        if (n == 0)
            return 0;
        if (n <= k)
            return b[n - 1];
        long f1[] = new long[k];
        for (int i = 0; i < k; i++)
            f1[i] = b[i];
        long t[][] = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i < k - 1) {
                    if (i + 1 == j)
                        t[i][j] = 1;
                    else
                        t[i][j] = 0;
                } else {
                    t[i][j] = c[k - j - 1];
                }
            }
        }
        t = power(t, n - 1);
        long res = 0;
        for (int i = 0; i < k; i++)
            res = (res + (t[0][i] * f1[i]) % MOD) % MOD;
        return res;
    }

    private static long[][] power(long a[][], int n) {
        if (n == 1)
            return a;
        if ((n & 1) == 1)
            return multiply(a, power(a, n - 1));
        else {
            long x[][] = power(a, n / 2);
            return multiply(x, x);
        }
    }

    private static long[][] multiply(long a[][], long b[][]) {
        long c[][] = new long[k][k];
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                for (int l = 0; l < k; l++)
                    c[i][j] = (c[i][j] + (a[i][l] * b[l][j]) % MOD) % MOD;
        return c;
    }
}