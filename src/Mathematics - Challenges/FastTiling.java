import java.util.Scanner;

public class FastTiling {
    private static long[] b;
    private static long MOD = 1000000007;

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int l = 0; l < 4; l++) {
                    C[i][j] = (C[i][j] + (A[i][l] * B[l][j]) % MOD) % MOD;
                }
            }
        }
        return C;
    }

    private static long[][] power(long[][] T, int n) {
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

    private static long calculate(int n) {
        //if value is less than k no need to calculate
        if (n == 0)
            return 0;
        if (n < 4)
            return b[n - 1];
        // finding F1 vector which is b
        // calculating the transformation matrix T
        long[][] T = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 1}
        };
        // calculate T^n-1
        T = power(T, n - 1);
        // calculate Fn
        long res = 0;
        for (int i = 0; i < 4; i++)
            res = (res + (T[0][i] * b[i]) % MOD) % MOD;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b = new long[]{1, 1, 1, 2};
        int n = sc.nextInt();
        System.out.println(calculate(n));
    }
}