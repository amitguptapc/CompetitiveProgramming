import java.util.Scanner;

public class AlphaScore {
    private static final long MOD = (long) (1e9 + 7);

    private static long alphaScoreHelper(long[] a, int s, int m, int e) {
        int n1 = m - s + 1;
        long[] l = new long[n1];
        for (int i = 0; i < n1; i++)
            l[i] = a[s + i];

        int n2 = e - m;
        long[] r = new long[n2];
        for (int i = 0; i < n2; i++)
            r[i] = a[m + i + 1];

        int i = 0, j = 0, k = s;
        long ans = 0;
        while (i < n1 && j < n2) {
            if (l[i] < r[j]) {
                ans = (ans + ((n2 - j) * l[i]) % MOD) % MOD;
                a[k++] = l[i++];
            } else a[k++] = r[j++];
        }
        while (i < n1)
            a[k++] = l[i++];
        while (j < n2)
            a[k++] = r[j++];
        return ans;
    }

    private static long alphaScore(long[] a, int s, int e) {
        if (s >= e)
            return 0;
        int mid = (s + e) / 2;
        long x = alphaScore(a, s, mid) % MOD;
        long y = alphaScore(a, mid + 1, e) % MOD;
        long z = alphaScoreHelper(a, s, mid, e) % MOD;
        return (((x + y) % MOD) + z) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(alphaScore(a, 0, n - 1));
    }
}