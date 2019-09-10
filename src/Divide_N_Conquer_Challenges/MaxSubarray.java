import java.util.Scanner;

public class MaxSubarray {
    private static long maxBridge(long[] a, int s, int m, int e) {
        long sum = 0;
        long lSum = Long.MIN_VALUE;
        for (int i = m; i >= s; i--) {
            sum += a[i];
            if (sum > lSum)
                lSum = sum;
        }
        sum = 0;
        long rSum = Long.MIN_VALUE;
        for (int i = m + 1; i <= e; i++) {
            sum += a[i];
            if (sum > rSum)
                rSum = sum;
        }
        return lSum + rSum;
    }

    private static long maxSum(long[] a, int s, int e) {
        if (s == e)
            return a[s];
        int m = (s + e) / 2;
        return Math.max(maxSum(a, s, m), Math.max(maxSum(a, m + 1, e), maxBridge(a, s, m, e)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextLong();
            System.out.println(maxSum(a, 0, n - 1));
        }
    }
}