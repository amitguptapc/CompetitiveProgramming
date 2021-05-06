package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

// https://www.codechef.com/INOIPRAC/problems/INOI1301
public class CalvinsGame {
    private static long findMaxScore(long[] a, int n, int k) {
        /*
        forward[i] = max score obtained when we start from k and move to i
        backward[i] = max score obtained when we move backwards from i to 0
        */
        long[] forward = new long[n];
        long[] backward = new long[n];
        forward[k - 1] = 0;
        forward[k] = a[k];
        for (int i = k + 1; i < n; i++)
            forward[i] = a[i] + Math.max(forward[i - 1], forward[i - 2]);

        backward[0] = a[0];
        backward[1] = a[0] + a[1];
        for (int i = 2; i < n; i++)
            backward[i] = a[i] + Math.max(backward[i - 1], backward[i - 2]);

        long ans = Long.MIN_VALUE;
        for (int i = k - 1; i < n; i++)
            ans = Math.max(ans, forward[i] + backward[i] - a[i]);

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(findMaxScore(a, n, k));
    }
}
