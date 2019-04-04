import java.util.Arrays;
import java.util.Scanner;

/**
 * In majority of the cases , the complexity of the DP program
 * is equal to the number of states in which the program can go.
 */

public class Fib {
    private static int[] a;

    // Pure DP (Botton up)
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
        a[n - 1] = fib2(n - 1);
        a[n - 2] = fib2(n - 2);
        a[n] = a[n - 1] + a[n - 2];
        return a[n];
    }

    // Naive approach
    private static int fib1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n + 1];
        Arrays.fill(a, -1);
        System.out.println(fib3(n));
    }
}