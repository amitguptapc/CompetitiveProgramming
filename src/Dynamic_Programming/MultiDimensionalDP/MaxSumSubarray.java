import java.util.Scanner;

public class MaxSumSubarray {
    private static long kadane(long[] a, int n) {
        long maxEndHere = 0, maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            maxEndHere += a[i];
            if (maxEndHere < 0)
                maxEndHere = 0;
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    private static long getMaxSum(long[][] a, int n, int m) {
        long[] row;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) { // for starting row
            row = new long[m];
            for (int j = i; j < n; j++) { // for ending row
                for (int k = 0; k < m; k++) {
                    row[k] += a[j][k];
                }
                max = Math.max(max, kadane(row, m));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        System.out.println(getMaxSum(a, n, m));
    }
}