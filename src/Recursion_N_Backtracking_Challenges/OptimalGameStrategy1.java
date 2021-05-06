import java.util.Scanner;

public class OptimalGameStrategy1 {
    private static long maxScore(long[] a, int i, int j, boolean turn) {
        if (i > j) {
            return 0;
        }
        long a1, a2;
        if (turn) {
            a1 = a[i] + maxScore(a, i + 1, j, false);
            a2 = a[j] + maxScore(a, i, j - 1, false);
            return Math.max(a1, a2);
        } else {
            a1 = maxScore(a, i + 1, j, true);
            a2 = maxScore(a, i, j - 1, true);
            return Math.min(a1, a2);
        }
    }

    // true represents Piyush's turn
    // false represents Namit's turn
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(maxScore(a, 0, n - 1, true));
    }
}