package Dynamic_Programming.OneDimensionalDP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * In majority of the cases , the complexity of the DP program
 * is equal to the number of states in which the program can go.
 */

public class Fib {
    private static int[] a;

    // Pure DP with space optimization
    private static int fib4(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c=0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // Pure DP (Bottom up)
    private static int fib3(int n) {
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++)
            a[i] = a[i - 1] + a[i - 1];
        return a[n];
    }

    // Memoization (Top Down)
    private static int fib2(int n) {
        if (n <= 1)
            return n;
        if (a[n] != -1)
            return a[n];
        a[n] = fib2(n - 1) + fib2(n - 2);
        return a[n];
    }

    // Naive approach
    private static int fib1(int n) {
        if (n <= 1)
            return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n + 1];
        Arrays.fill(a, -1);
        System.out.println(fib4(n));
    }
}