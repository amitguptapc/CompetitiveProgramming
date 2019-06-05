import java.util.Scanner;

public class OptimalGameStrategy1 {
    private static long maxScore(long[] a, int i, int j, boolean turn) {
        if (i == j) {
            return 0;
        }
        if (a[i] > a[j]) {
            if (turn)
                return a[i] + maxScore(a, i + 1, j, false);
            else
                return maxScore(a, i + 1, j, true);
        } else {
            if (turn)
                return a[j] + maxScore(a, i, j - 1, false);
            else return maxScore(a, i, j - 1, true);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(maxScore(a, 0, n - 1, true));
    }
}