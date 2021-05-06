package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class LISModified {
    private static long findLCS(int[] a, int[] w, int n) {
        long[] memo = new long[n];
        for (int i = 0; i < n; i++)
            memo[i] = w[i];
        long ans = memo[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    long temp = w[i] + memo[j];
                    memo[i] = Math.max(temp, memo[i]);
                }
            }
            ans = Math.max(ans, memo[i]);
        }
        return ans;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] w = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                w[i] = sc.nextInt();
            System.out.println(findLCS(a, w, n));
        }
    }
}