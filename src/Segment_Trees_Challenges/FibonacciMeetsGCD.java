import java.util.Arrays;
import java.util.Scanner;

public class FibonacciMeetsGCD {
    private static final long MOD = 1000000007;
    private static long[] a;
    private static long[] tree;

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 2; l++) {
                    C[i][j] = (C[i][j] + (A[i][l] * B[l][j]) % MOD) % MOD;
                }
            }
        }
        return C;
    }

    private static long[][] power(long[][] T, long n) {
        // base case
        if (n == 1)
            return T;
        // if n is even
        if ((n & 1) == 1)
            return multiply(T, power(T, n - 1));
        else {
            long[][] X = power(T, n / 2);
            return multiply(X, X);
        }
    }

    // Matrix Exponentiation
    private static long fib(long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        // finding F1 vector which is b
        long[] b = {1, 1};
        // calculating the transformation matrix T
        long[][] T = {{0, 1}, {1, 1}};
        // calculate T^n-1
        T = power(T, n - 1);
        // calculate Fn
        long res = 0;
        for (int i = 0; i < 2; i++)
            res = (res % MOD + (T[0][i] % MOD * b[i] % MOD) % MOD) % MOD;
        return res % MOD;
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long query(int s, int e, int qs, int qe, int idx) {
        if (qs > e || qe < s)
            return 0;
        if (qs <= s && qe >= e)
            return tree[idx];
        int m = (s + e) / 2;
        long l = query(s, m, qs, qe, 2 * idx);
        long r = query(m + 1, e, qs, qe, 2 * idx + 1);
        return gcd(l, r);
    }

    private static void build(int s, int e, int idx) {
        if (s == e) {
            tree[idx] = a[s];
            return;
        }
        int m = (s + e) / 2;
        build(s, m, 2 * idx);
        build(m + 1, e, 2 * idx + 1);
        tree[idx] = gcd(tree[2 * idx], tree[2 * idx + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        a = new long[n];
        tree = new long[4 * n + 1];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        build(0, n - 1, 1);
        while (q-- > -0) {
            System.out.println(fib(query(0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1, 1)));
        }
    }
}