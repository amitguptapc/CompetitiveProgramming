import java.util.Scanner;

public class OptimalGameStrategy2 {
    private static long[][] dpt;
    private static long[][] dpf;

    private static long maxScore(long[] a, int i, int j, boolean turn) {
        if (i == j) {
            dpf[i][j] = dpt[i][j] = 0;
        }
        if (turn) {
            if (dpt[i][j] != -1)
                return dpt[i][j];
            return dpt[i][j] = Math.max(a[i] + maxScore(a, i + 1, j, false),
                    a[j] + maxScore(a, i, j - 1, false));
        } else {
            if (dpf[i][j] != -1)
                return dpf[i][j];
            return dpf[i][j] = Math.min(maxScore(a, i + 1, j, true),
                    maxScore(a, i, j - 1, true));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        dpt = new long[n + 1][n + 1];
        dpf = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                dpt[i][j] = dpf[i][j] = -1;
            }
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(maxScore(a, 0, n - 1, true));
    }
}