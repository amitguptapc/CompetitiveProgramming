import java.util.Arrays;
import java.util.Scanner;

public class DeepakNPrimes2 {
    private static int[] an;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        an = sieve();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            int[] res = segment(a, b);
            for (int i = 0; i < (b - a) + 1; i++) {
                if (a == 1 && i == 0)
                    continue;
                if (res[i] == 1)
                    System.out.println(i + a);
            }
            System.out.println();
        }
    }

    // make sieve of size 3200 which is root of 10^9

    private static int[] sieve() {
        int[] a = new int[32000 + 1];
        a[2] = 1;
        for (int i = 3; i <= 32000; i += 2)
            a[i] = 1;
        for (int i = 3; i * i <= 32000; i += 2) {
            if (a[i] == 1) {
                for (int j = i * i; j <= 32000; j += 2 * i)
                    a[j] = 0;
            }
        }
        return a;
    }

    private static int[] segment(long a, long b) {
        int[] res = new int[(int) (b - a) + 1];
        Arrays.fill(res, 1);
        for (long i = 2; i * i <= b; i += 1) {// iterate each element of the root(b) sieve
            if (an[(int) i] == 1) {
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