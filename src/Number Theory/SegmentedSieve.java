import java.util.Arrays;
import java.util.Scanner;

public class SegmentedSieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        int[] res = segment(a, b);
        for (int i = 0; i < res.length; i++)
            if (res[i] == 1)
                System.out.print(i + a + " ");
    }

    private static int[] sieve(int n) {
        int[] a = new int[n + 1];
        a[2] = 1;
        for (int i = 3; i <= n; i += 2)
            a[i] = 1;
        for (int i = 3; i*i <= n; i += 2) {
            if (a[i] == 1) {
                for (int j = i * i; j <= n; j += 2 * i)
                    a[j] = 0;
            }
        }
        return a;
    }

    private static int[] segment(long a, long b) {
        int[] val = sieve((int) Math.sqrt(b));
        int[] res = new int[(int) (b - a) + 1];
        Arrays.fill(res, 1);
        for (long i = 2; i * i <= b; i += 1) {// iterate each element of the root(b) sieve
            if (val[(int) i] == 1) {
                for (long j = a; j <= b; j++) {
                    if (i == j)// if the sieves overlap skip
                        continue;
                    if (j % i == 0)
                        res[(int) (j - a)] = 0;
                }
            }
        }
        return res;
    }
}