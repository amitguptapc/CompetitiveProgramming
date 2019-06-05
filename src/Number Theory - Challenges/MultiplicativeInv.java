import java.util.Scanner;

public class MultiplicativeInv {
    private static long x, y;

    private static void inv(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        inv(b, a % b);
        long cx = y;
        long cy = x - (a / b) * y;
        x = cx;
        y = cy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = 1000000007;
        inv(n, m);
        x = (x + m) % m;
        System.out.println(x);
    }
}