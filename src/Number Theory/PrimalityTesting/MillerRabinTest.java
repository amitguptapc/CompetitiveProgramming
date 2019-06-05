import java.util.Scanner;

public class MillerRabinTest {
    private static long power(long a, long b, long m) {
        long r = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) == 1)
                r = (r * a) % m;
            b >>= 1;
            a = (a * a) % m;
        }
        return r;
    }

    private static boolean millerTest(long d, long n) {
        long a = 2 + (long) (Math.random() % (n - 4));
        long x = power(a, d, n);
        if (x == 1 || x == n - 1)
            return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;
            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false;
    }

    private static boolean isPrime(long n) {
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
        long d = n - 1;
        while (d % 2 == 0)
            d /= 2;
        int k = 8;
        while (k-- > 0)
            if (!millerTest(d, n))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (int i = 1; i <= n; i++)
            System.out.println(isPrime(i) ? i : "");
    }
}