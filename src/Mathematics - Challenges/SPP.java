import java.util.Scanner;

public class SPP {
    private static int k;
    private static long[] b, c;
    private static long p;

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    C[i][j] = (C[i][j] + (A[i][l] * B[l][j]) % p) % p;
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

    private static long calculate(long n) {
        // base case
        if (n == 0)
            return 0;
        if (n <= k)
            return b[(int) n - 1];
        // finding F1 vector which is b
        // calculating the transformation matrix T
        long[][] T = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i < k - 1) {
                    if (j == i + 1)
                        T[i][j] = 1;
                    else T[i][j] = 0;
                    continue;
                }
                // filling the last row
                T[i][j] = c[k - j - 1];
            }
        }
        // calculate T^n-1
        T = power(T, n - 1);
        // calculate Fn
        long res = 0;
        for (int i = 0; i < k; i++)
            res = (res + (T[0][i] * b[i]) % p) % p;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            k = sc.nextInt();
            b = new long[k];
            c = new long[k];
            for (int i = 0; i < k; i++)
                b[i] = sc.nextInt();
            for (int i = 0; i < k; i++)
                c[i] = sc.nextInt();
            long m = sc.nextLong();
            long n = sc.nextLong();
            p = sc.nextLong();
            long x = calculate(m + 1);
            long y = calculate(n + 2);
            System.out.println(((y - x) + p) % p);
        }
    }
}