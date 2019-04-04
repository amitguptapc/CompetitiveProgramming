import java.util.Scanner;

public class FastModuloExpo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(fastModuloExpo(a, b, m));
    }

    // Compute a^b wrt mod m
    // in O(log n) complexity,
    // using bitmask.
    private static long fastModuloExpo(long a, long b, long m) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b = b >> 1;
        }
        return res;
    }
}