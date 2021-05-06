package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// can also be solved by formula
// catalan(n) = (2nCn)/(n+1)

public class CatalanNumbers {
    // DP approach O(n^2)
    private static long findCatalan(int n) {
        long[] catalan = new long[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                catalan[i] += catalan[j - 1] * catalan[i - j];
        }
        return catalan[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findCatalan(n));
    }
}